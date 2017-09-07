package queues

/**
  * Created by thiago on 12/12/16.
  */
class Queue[A] {

   var head: Node[A] = EmptyNode
   var tail: Node[A] = EmptyNode

   def add(e: A): Unit = {
     head match {
       case EmptyNode => {
        head = NonEmptyNode(e,tail,EmptyNode)
       }
       case n: NonEmptyNode[A] => {
         tail = if(tail.isEmpty) NonEmptyNode(e,EmptyNode,head)
                else NonEmptyNode(e,EmptyNode,tail)
       }
     }
   }

   def remove():A = {
     val data = head.data()
     head = head.previous()
     data
   }

   def isEmpty = tail.isEmpty && head.isEmpty

}

sealed trait Node[+A]{
  def data(): A
  def next(): Node[A]
  def previous(): Node[A]
  def isEmpty: Boolean
}

case class NonEmptyNode[+A](data: A, previous: Node[A], next: Node[A]) extends Node[A]{
  override def isEmpty = false
}

object EmptyNode extends Node[Nothing]{
  override def next() = throw new NoSuchElementException
  override def previous() = throw new NoSuchElementException
  override def data() = throw new NoSuchElementException
  override def isEmpty = true
}