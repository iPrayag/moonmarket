package zazzercode

import net.liftweb.common.{Loggable}
import org.elasticsearch.node.NodeBuilder.nodeBuilder
import scala.io.Source

/**
  * curl -XGET http://localhost:9200/logs/log/1
  */ 
object ElasticBulkload extends App with Loggable {
  val node = nodeBuilder().client(true).node()
  val client = node.client()
 
  val jsons = Source.fromFile("src/main/resources/log.json").getLines().toList
  for (i <- 1 to jsons.length) {
    indexJson(jsons(i - 1), i.toString)
  }
 
  def indexJson(json: String, id: String) = {
    client.prepareIndex("logs", "log", id).setSource(json).execute().actionGet()
  }
 
}
