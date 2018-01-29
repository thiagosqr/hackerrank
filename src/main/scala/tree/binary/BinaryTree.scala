package tree.binary

object BinaryTree {

//  def makeIntegerBinTree(): BinaryTree[Int] ={
//
//    implicit val f: (Int,Int) => Int = (a,b) => {
//      if(a == b) 0
//      else if(a > b) 1
//      else  -1
//    }
//
//    BinaryTree[Int](f)
//
//  }
//
//
//}
//
//case class BinaryTree[T](c: (T,T) => Int) {
//
//  var head: Node[T] = null
//
//  def add(n: T): Unit = head match {
//      case NonEmptyNode(d,l,r) => head.add(n)(c)
//      case _ => head = NonEmptyNode(n, EmptyNode, EmptyNode)
//  }
//
//}
//
//
//sealed trait Node[+A]{
//
//  def data: A
//  def isEmpty(): Boolean
//  def contains[B >: A](u: B): Boolean
//  def left(): Node[A]
//  def right(): Node[A]
//  def add[B >: A](n: B)(implicit c: (B,B) => Int): Unit
//}
//
//case object EmptyNode extends Node[Nothing]{
//  override def isEmpty = true
//  override def contains[B >: Nothing](x: B) = false
//  override def data = throw new NoSuchElementException
//  override def left = throw new NoSuchElementException
//  override def right = throw new NoSuchElementException
//  override def add[B >: Nothing](n: B)(implicit c: (B, B) => Int): Unit =
//    throw new NotImplementedError()
//}
//
//case class NonEmptyNode[+A](data: A, var left: Node[A], var right: Node[A]) extends Node[A]{
//
////  self =>
//
//  override def isEmpty = false
//  override def contains[B >: A](u: B): Boolean = false
//
//  override def add[B >: A](n: B)(implicit c: (B,B) => Int): Unit = {
//
////    self.isEmpty
//
//    val r = c.apply(n, data)
//
//    if(r < 0) left match {
////      case EmptyNode => left = NonEmptyNode(n, EmptyNode, EmptyNode)
//      case NonEmptyNode(d,l,r) => left.add(n)
//    }else if(r > 0) right match {
////      case EmptyNode => right = NonEmptyNode(n, EmptyNode, EmptyNode)
//      case NonEmptyNode(d,l,r) => right.add(n)
//    }
//
//  }

}

