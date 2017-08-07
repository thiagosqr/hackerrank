package insertionsort

import algorithms.sorting.insertionsort.Solution
import org.scalatest._

/**
  * Created by thiago on 10/11/16.
  */
class InsertionSortTest extends FreeSpec {

  "Insertion Sort" - {
    "when given first line with value 5 and second line with value 2 3 5 6 4" - {

      "it should print one line for every character switch" in {

        val args = new Array[String](2)
        args(0) = "5"
        args(1) = " 2 4 6 8 3"
        val result = List("2 4 6 8 8", "2 4 6 6 8", "2 4 4 6 8", "2 3 4 6 8")

        Solution.main(args)

        val noDiff = Solution.list.zip(result).filter(x => x._1 == x._2).size

        assert(noDiff == result.size)

      }


    }
  }




}
