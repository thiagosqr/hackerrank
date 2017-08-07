package amnagrams

import java.io.{ByteArrayOutputStream, PrintStream}

import anagrams.{Solution, SolutionImperative}
import org.scalatest.FreeSpec

import scala.io.StdIn

/**
  * Created by thiago on 09/01/17.
  */
class AnagarmsTest extends FreeSpec {

  "Insertion Sort" - {
    "when given first line with value 5 and second line with value 2 3 5 6 4" - {

      "it should print one line for every character switch" in {

        val baos = new ByteArrayOutputStream()
        System.setOut(new PrintStream(baos))

        val args = new Array[String](2)
        args(0) = "cde"
        args(1) = "abc"

        SolutionImperative.main(args)

        val result = new String(baos.toByteArray)

        assert(result === 4)

      }


    }
  }

}
