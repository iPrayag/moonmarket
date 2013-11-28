package bootstrap.liftweb

import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.net.liftweb.http._
import _root_.net.liftweb.http.provider._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import Helpers._
import _root_.net.liftweb.mapper.{DB, ConnectionManager, Schemifier, DefaultConnectionIdentifier, StandardDBVendor,ConnectionIdentifier}
import _root_.java.sql.{Connection, DriverManager}
import _root_.com.zam.gwitter.model._
import zazzercode._

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def startElasticsearch(){
    ElasticBulkload
  }

  def boot {
    startElasticsearch()

    if (!DB.jndiJdbcConnAvailable_?) {
      //println("jndiJdbcConnAvailable_ : " + DB.jndiJdbcConnAvailable_);
      val vendor = 
	new StandardDBVendor(Props.get("db.driver") openOr "org.h2.Driver",
			     Props.get("db.url")     openOr  "jdbc:h2:lift_proto.db;AUTO_SERVER=TRUE",
			     Props.get("db.user"), 
			     Props.get("db.password")
			     )

      LiftRules.unloadHooks.append(vendor.closeAllConnections_! _)

      DB.defineConnectionManager(DefaultConnectionIdentifier, vendor)
    }

    // where to search snippet
    LiftRules.addToPackages("com.zazzercode.gwitter")
    Schemifier.schemify(true, Schemifier.infoF _, User)

    // Build SiteMap
    def sitemap() = SiteMap(
      Menu("Home") / "index" >> User.AddUserMenusAfter, // Simple menu form
      // Menu with special Link
      Menu(Loc("Purchase land", 
                List("purchase", "purchase"),
               "Purchase")
              ),
     Menu(Loc("Request", 
             List("jsontable", "jsontable"), 
             "Request")
         ),

      Menu(Loc("What's Lunar Market", 
               Link(List("about"), true, "/about/index"), 
	       "About Lunar Market")
	       )
	   )

    LiftRules.setSiteMapFunc(() => User.sitemapMutator(sitemap()))

    /*
     * Show the spinny image when an Ajax call starts
     */
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

    /*
     * Make the spinny image go away when it ends
     */
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    LiftRules.early.append(makeUtf8)

    LiftRules.loggedInTest = Full(() => User.loggedIn_?)

    /*
     * hook RestController
     */
    LiftRules.dispatch.append(RestController) // stateful — associated with a servlet container session
    LiftRules.statelessDispatchTable.append(RestController) // stateless — no session created

    S.addAround(DB.buildLoanWrapper)

   Logger.setup = Empty
  }//end of boot

  /**
   * Force the request to be UTF-8
   */
  private def makeUtf8(req: HTTPRequest) {
    req.setCharacterEncoding("UTF-8")
  }
}


