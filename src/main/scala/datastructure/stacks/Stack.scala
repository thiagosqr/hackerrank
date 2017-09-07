package datastructure.stacks

class Stack[A] {

  private[this] var head: Node[A] = EmptyNode

  def add(e: A): Unit = {
    val h = head
    head = new NonEmptyNode[A](e, h)
  }

  def isEmpty = head.isEmpty

  def pop(): A = {
    val h = head
    head = h.previous()
    h.data()
  }

  def peek(): A = {
    head match {
      case NonEmptyNode(d,p) => d
      case EmptyNode => throw new NoSuchElementException
    }

  }


}

sealed trait Node[+A]{
  def data(): A
  def previous(): Node[A]
  def isEmpty: Boolean
}

case class NonEmptyNode[+A](data: A, previous: Node[A]) extends Node[A]{
  override def isEmpty = false

}

object EmptyNode extends Node[Nothing]{
  override def previous() = throw new NoSuchElementException
  override def data() = throw new NoSuchElementException
  override def isEmpty = true
}

