package movies

import play.api.libs.json.Json

case class MovieResponse(page: String, per_page: Int, total: Int,
                         total_pages: Int, data: List[Movie])

object  MovieResponse {
  implicit val movieResponseReads = Json.reads[MovieResponse]
}
