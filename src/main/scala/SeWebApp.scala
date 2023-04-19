import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{array_contains, col, explode, monotonically_increasing_id, split}
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.clustering.KMeans
import org.scalatra._
import org.scalatra.scalate.ScalateSupport

class SeWebApp(spark: SparkSession) extends ScalatraServlet with ScalateSupport {

  get("/") {
    contentType="text/html"
    ssp("/index")
  }

  post("/") {
    val playerId = params("player_id").toInt
    val result = Se.FindCluster(playerId, spark)
    contentType="text/html"
    ssp("/result", "result" -> result)
  }

}

object SeWebApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("Clustering").getOrCreate()
    val port = if (System.getenv("PORT") != null) System.getenv("PORT").toInt else 8080
    val app = new SeWebApp(spark)
    app.port = port
    app.start()
  }
}
