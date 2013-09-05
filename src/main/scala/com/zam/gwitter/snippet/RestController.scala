package zazzercode

import net.liftweb._
import common._
import http._
import rest._
import json._
import scala.xml._

/**
  * author : Prayag
  */
object RestController extends RestHelper {

  /*
   * Serve the URL 
   * "/api/validate"
   * add a *.xml or *.json (depending in what you have implemented) at the end of the URL 
   * eg http://localhost:8080/XXX/api/validate/call.json
   */
 serve { 
   case XmlGet("api" :: "validate" :: _, _) => <ns2:mobile-pickup-validation-request xmlns:ns2="http://www.westernunion.com/schema/xrsi"><mobile_partner><id>NABILNPT</id><system><id>TESTTEST</id><name>WU-MMT-PILOT-SVR</name><version>9101</version><ip_address>192.168.1.1</ip_address><connector><id>NABNP002</id></connector></system></mobile_partner><mobile_wallet><id>MWS1</id></mobile_wallet></ns2:mobile-pickup-validation-request>
   case JsonGet("api" :: "validate" :: _, _) => JString("Validated") 
 }   
}
