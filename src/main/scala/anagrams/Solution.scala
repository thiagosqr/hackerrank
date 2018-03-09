package anagrams

import scala.io.Source

/**
  * Created by thiago on 09/01/17.
  */
object Solution extends App {

    val inputs = if(args.size > 0) args.toList
                 else Source.stdin.getLines.toList

    val a = inputs(0)
    val b = inputs(1)

    val diffa = a.diff(b)
    val diffb = b.diff(a)

    println(diffa.length + diffb.length)


    trait Thing

    trait Vehicle extends Thing
    class Car extends Vehicle
    case class Jeep(i: Int) extends Car
    case class Coupe(i: Int) extends Car
    case class Motorcycle(i: Int) extends Vehicle

    trait Vegetable extends Thing
    class Tomato extends Vegetable
    class Cucumber extends Vegetable

    val f1 = (t: Car) => new Tomato


}
