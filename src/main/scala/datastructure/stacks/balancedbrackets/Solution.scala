package datastructure.stacks.balancedbrackets

import scala.Char

/**
  * Created by thiago on 27/09/16.
  */
object Solution extends App {

  val sc = new java.util.Scanner (System.in)
  val strings = readString(sc.nextInt)

  val balanced = for {
    s <- strings
    if(isBalanced(s, '[', ']'))
  } yield s

  strings.foreach(s => if(balanced.contains(s)) println("YES") else println("NO"))

  def isBalanced(s: String, open: Char, close: Char): Boolean =

    s.toCharArray.foldLeft(0)((z, c) => {
      if (z < 0) Integer.MIN_VALUE
      else c match {
        case '[' => z + 1
        case ']' => z - 1
      }
    }) == 0


  def readString(n: Int): List[String] =
    if(n > 0) sc.next.trim :: readString(n-1)
    else List()

}
