package queues

/**
  * Created by thiago on 14/12/16.
  */
object Solution extends App {

  val q = new Queue

  val inputs = args.drop(1).map(_.split(" "))
  for(input <- inputs) yield input match {
    case Array("1",b) => q.add(b)
    case Array("2") => if(!q.head.isEmpty) q.remove()
    case Array("3") => if(!q.head.isEmpty) println(q.head.data())
  }

}
