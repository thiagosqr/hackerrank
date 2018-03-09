package anagrams

import anagrams.Solution.args

import scala.io.Source

/**
  * Created by thiago on 09/01/17.
  */
object SolutionImperative extends App {

  val inputs = if (args.size > 0) args.toList
  else Source.stdin.getLines.toList

  val a = inputs(0)
  val b = inputs(1)

  val diffA = for (xa <- a if (!b.contains(xa))) yield xa
  val diffB = for (xb <- b if (!a.contains(xb))) yield xb

  println(diffA.length + diffB.length)

}