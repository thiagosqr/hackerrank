package algorithms.sorting.insertionsort

/**
  * Created by thiago on 07/11/16.
  */
object Solution extends App{

  val arrSize = scanner.nextInt
  val arr = new Array[Int](arrSize)
  val line = scanner.nextLine.trim.split(" ")
  for(i <- 0 to arrSize-1) arr(i) = line(i).toInt
  val input = arr(arrSize-1)

  for(i <- arrSize-1 to 0 by -1){
    if(i > 0 && arr(i-1) > input) arr.update(i, arr(i-1))
    else if(arr(i) != input) arr.update(i, input)
    println (arr.map(_.toString).reduce(_ + " " + _))
  }

  def scanner = new java.util.Scanner (System.in)

}
