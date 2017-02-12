package hashtables

import java.io._

/**
  * Created by thiago on 08/02/17.
  */
class RansomNoteTest extends org.scalatest.FreeSpec {

  "Ransom Note" - {
      "Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No." in {

        val baos = new ByteArrayOutputStream()
        System.setOut(new PrintStream(baos))

        val mN = "6 4\n"
        val mag = mN + "give me one grand today night\n"
        val note = mag + "give one grand today"

        System.setIn( new ByteArrayInputStream(note.getBytes("UTF-8")))

        hashtables.Solution.main(Array())

        val result = new String(baos.toByteArray)
        assert(result === "Yes")

      }

    "LArge input." in {

//      val baos = new ByteArrayOutputStream()
//      System.setOut(new PrintStream(baos))

      val f = new FileInputStream(new File("/Users/thiago/workspaces/github/thiagosqr/hackerrank/src/test/resources/large_input.txt"))
      val fAsBArr = new Array[Byte](360*1000)
      f.read(fAsBArr)
      System.setIn( new ByteArrayInputStream(fAsBArr))

      hashtables.Solution.main(Array())

//      val result = new String(baos.toByteArray)
//      assert(result === "Yes")

    }

  }

}
