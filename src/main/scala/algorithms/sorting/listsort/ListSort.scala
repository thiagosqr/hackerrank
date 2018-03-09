package algorithms.sorting.listsort

/**
  * Created by thiago on 20/12/16.
  */
object ListSort extends App{

  def sort(l :List[Int]): List[Int] = l match {
      case Nil => Nil
      case x :: xs =>
        val (a, b) = xs.partition(_ < l.head)
        sort(a) ++ (x :: sort(b))
    }

  println(sort(List(3, 5, 6, 8, 2, 1, 7, 9, 0)))

//  Spilt list into < head concact head concat > head
//  List(3, 5, 6, 8, 2, 1, 7, 9, 0)

//  List(2, 1, 0)
//  List(1, 0)
//  List(0)
//  List(5, 6, 8, 7, 9)
//  List(6, 8, 7, 9)
//  List(8, 7, 9)
//  List(7)
//  List(9)
//  List(0, 1, 2, 3, 5, 6, 7, 8, 9)
}
