package queues

/**
  * Created by thiago on 14/12/16.
  */
object QueueRunner extends App {

  val arguments = new Array[String](11)
  arguments(0) = "10"
  arguments(1) = "1 42"
  arguments(2) = "2"
  arguments(3) = "1 14"
  arguments(4) = "3"
  arguments(5) = "1 28"
  arguments(6) = "3"
  arguments(7) = "1 60"
  arguments(8) = "1 78"
  arguments(9) = "2"
  arguments(10) = "2"


  Solution.main(arguments)

}
