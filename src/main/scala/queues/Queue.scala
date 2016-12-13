package queues

/**
  * Created by thiago on 12/12/16.
  */
class Queue {

   private[this] var head: Node = EmptyNode
   private[this] var tail: Node = EmptyNode

   def add(e: String): Unit = {
     head match {
       case EmptyNode => {
        head = NonEmptyNode(e,EmptyNode,EmptyNode)
       }
       case n: NonEmptyNode => {

         tail = if(tail.isEmpty) NonEmptyNode(e,EmptyNode,head)
                else NonEmptyNode(e,EmptyNode,tail)
       }
     }
   }

   def remove():String = {

     val data = head.data()



     data

   }

}

sealed trait Node{
  def data(): String
  def next(): Node
  def previous(): Node
  def isEmpty: Boolean
}

case class NonEmptyNode(data: String, previous: Node, next: Node) extends Node{
  override def isEmpty = false
}

object EmptyNode extends Node{
  override def next() = throw new NoSuchElementException
  override def previous() = throw new NoSuchElementException
  override def data() = throw new NoSuchElementException
  override def isEmpty = true
}