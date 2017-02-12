package anagrams

/**
  * Created by thiago on 09/01/17.
  */
object Solution extends App {

    val inputs = if(args.size > 0) args.toList
                 else io.Source.stdin.getLines.toList

    val a = inputs(0)
    val b = inputs(1)

    val diffa = a.diff(b)
    val diffb = b.diff(a)

    println(diffa.length + diffb.length)



}
