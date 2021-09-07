import scalaj.http._
import play.api.libs.json._

import scala.reflect.runtime.universe.typeOf

object WebReq extends App {
  var maxRows = 5
  //val response: HttpResponse[String] = Http("http://example.com/search").param("q","monkeys").asString
  //val response: HttpResponse[String] = Http("http://api.geonames.org/findNearbyWikipediaJSON?lat=42.37&lng=-71.18&maxRows=20&username=petecities").asString
  val inputs = Seq.apply(
    ("username", "petecities"),
    //("lat", "42.37"),
    //("lng", "-71.18"),
    ("postalcode", "02452"),
    ("country", "US"),
    ("maxRows", maxRows.toString)
  )
  val response: HttpResponse[String] = Http("http://api.geonames.org/findNearbyWikipediaJSON?")
    .params(inputs)
    .asString

  println("HTTP Status: " + response.code)
  //println(response.body)

  val jsonRes: JsValue = Json.parse(response.body)

  var a = 0
  for (a <- 0 to maxRows - 1) {
    // read up here for converting json to string
    // https://www.playframework.com/documentation/2.8.x/ScalaJson
    // var title = (jsonRes \ "geonames" \ a \ "title").asOpt[String]
    var title = (jsonRes \ "geonames" \ a \ "title").get
    var url = (jsonRes \ "geonames" \ a \ "wikipediaUrl").get
    var desc = (jsonRes \ "geonames" \ a \ "summary").get
    println(s"${a + 1} : $title - $url \n $desc \n")
  }
  var headers = response.headers
  for (i <- headers) {
    println(i)
  }
}