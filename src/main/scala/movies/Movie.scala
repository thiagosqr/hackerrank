package movies

import play.api.libs.json.Json

case class Movie(Poster: String, Title: String, Type: String,
                 Year: Int, imdbID: String)

object Movie {
  implicit val movieReads = Json.reads[Movie]
}
