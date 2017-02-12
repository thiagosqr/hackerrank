package hashtables

/**
  * Created by thiago on 08/02/17.
  */
object Solution extends App{

  val sc = new java.util.Scanner (System.in)

  var m = sc.nextInt()
  var n = sc.nextInt()

  sc.nextLine()

  var magz = sc.nextLine().split(" ")
               .map(_.toLowerCase).toSet

  var note = sc.nextLine().split(" ").map(_.toLowerCase).toList

  var replic = checkWord(note)

  println( if(replic) "Yes" else "No" )

  def checkWord(mag: List[String]): Boolean = mag match {
    case List() => false
    case word :: Nil => magz contains word
    case x :: xs => if(magz contains x) checkWord(xs) else false
  }





}
