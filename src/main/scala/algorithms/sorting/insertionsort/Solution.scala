package algorithms.sorting.insertionsort

import java.util

/**
  * Created by thiago on 07/11/16.
  */
object Solution extends App {

  val sc = new java.util.Scanner (System.in)
  val strings =  if (args.length > 0) args.toList else readString(2)
  val arrSize = strings(0).toInt
  val arr = new Array[Int](arrSize)
  val line = strings(1).trim.split(" ")
  for(i <- 0 to arrSize-1) arr(i) = line(i).toInt
  val input = arr(arrSize-1)
  val list = for(i <- arrSize-1 to 0 by -1 if isUpdatable(i))
                yield arr.map(_.toString).reduce(_ + " " + _)

  list.foreach(println)

  def isUpdatable(i: Int): Boolean = {
    if(i > 0 && arr(i-1) > input){
      arr.update(i, arr(i-1))
      true
    } else if(arr(i) != input && arr(i) > input){
      arr.update(i, input)
      true
    } else false
  }

  def readString(n: Int): List[String] =
    if(n > 0) sc.nextLine().trim :: readString(n-1)
    else List()

}
