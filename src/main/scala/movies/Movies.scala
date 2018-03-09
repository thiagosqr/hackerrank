package movies

import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object Movies {

    def main(args: Array[String]): Unit = {

      lazy val movieService = new MovieService()

      val f = movieService.fetchMovie("a")

      f onComplete  {
        case Success(l) => l.foreach(System.out.println(_))
        case Failure(e) => e.printStackTrace()
      }

    }

}
