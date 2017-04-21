import scala.collection.mutable

//(a, b) => if(a > b) a else b
def max(xs: Array[Int]): Int = xs.fold(Int.MinValue)(math.max)


max(Array(1,2,3))


trait Traversable[T] {
  def foreach(f: T => Unit): Unit
  def newBuilder: mutable.Builder[T, Traversable[T]]
  def filter(p: T => Boolean): Traversable[T] = {
    val b = newBuilder
    foreach(el => if(p(el)) b += el)
    b.result
  }
}

