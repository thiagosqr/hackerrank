package sorting

/**
  * Created by thiago on 20/12/16.
  */
object ListSort extends App{

  def sort(l :List[Int]): List[Int] = l match {
    case Nil => Nil
    case x :: xs =>
        val (a,b) = xs.partition(_ < l.head)
        sort(a) ++ (x :: sort(b))
    }

  println(sort(List(3,5,6,8,2,1,7,9,0)))


}
