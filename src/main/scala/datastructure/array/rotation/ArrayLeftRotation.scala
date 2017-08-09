package datastructure.array.rotation

import anagrams.Solution.args
import datastructure.stacks.balancedbrackets.Solution.{readString, sc}

/**
  *  1 2 3 4 5
  *  left rotate twice
  *
  *  3 4 5 1 2
  *
  */
object ArrayLeftRotation {

    def main(args: Array[String]): Unit = {

      val sc = new java.util.Scanner (System.in);
      var n = sc.nextInt();
      var rotation = sc.nextInt();
      var arr = new Array[Int](n)
      for(a_i <- 0 to n-1) {
        arr(a_i) = sc.nextInt();
      }

      val tmp = arr.take(rotation)

      for(i <- rotation to arr.length-1){
        arr(i-rotation) = arr(i)
      }

      val rotdArr = arr.take(arr.length - rotation) ++ tmp

      rotdArr.foreach(i => System.out.print(i + " "))

    }

}
