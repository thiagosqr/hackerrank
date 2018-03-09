package movies

import java.util.UUID
import java.util.concurrent.TimeUnit

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import org.joda.time.DateTime
import play.api.libs.json._
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.ahc.{StandaloneAhcWSClient, StandaloneAhcWSRequest, StandaloneAhcWSResponse}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future, Promise}
import scala.util.{Failure, Success}


class MovieService {

  val apiUrl = "https://jsonmock.hackerrank.com/api/movies/search/"

  // Create Akka system for thread and streaming management
  implicit lazy val system = ActorSystem()
  system.registerOnTermination {
    System.exit(0)
  }
  implicit lazy val materializer = ActorMaterializer()

  lazy val wsClient = StandaloneAhcWSClient()

  private[this] def movieRequest(url: String): Future[MovieResponse] = {

    val p = Promise[MovieResponse]()

    val call = wsClient.url(url).get().onComplete{
      case Failure(e) => p.failure(e)
      case Success(r) => {
        System.out.println(Thread.currentThread().toString + url)
        p.trySuccess(r.body[JsValue].validate[MovieResponse].get)
      }

    }

    p.future

  }

//  Or Less desirable
//  private[this] def movieRequest(title: String, page: Int): Future[MovieResponse] = Future{
//
//    val url = apiUrl+s"?Title=$title&page=$page"
//    System.out.println(Thread.currentThread().toString + url)
//
//    val call = wsClient.url(url).get().map { r =>
//      r.body[JsValue].validate[MovieResponse].get
//    }
//
//    Await.result(call, Duration(2,TimeUnit.SECONDS))
//
//  }


  def fetchMovie(title: String): Future[List[Movie]] = {

    movieRequest(url(title,1)).flatMap { mr =>
      if(mr.total_pages <= 1) Future.successful(mr.data)
      else {
        Future.traverse(2 to mr.total_pages) { p =>
          movieRequest(url(title,p)).map(mrr => mrr.data)
        }.map(seq => mr.data ++ seq.flatten.toList)
      }
    }

  }

  //      val futurePages = Range.apply(2,mr.total_pages+1).map { p =>
  //        movieRequest(title,p).map(mrr => mrr.data)
  //      }.toList
  //      val fs = Future.sequence(futurePages)
  //      fs.map(l => l.flatten)


  def url(title: String, page: Int) = apiUrl+s"?Title=$title&page=$page"



}
