package datastructure.stacks.queues

import datastructure.stacks.Stack
import queues.Queue

object Solution {

  /**
    * A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.

A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.
In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:

1 x: Enqueue element  into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
Input Format

The first line contains a single integer, , denoting the number of queries.
Each line  of the  subsequent lines contains a single query in the form described in the problem statement above. All three queries start with an integer denoting the query , but only query  is followed by an additional space-separated value, , denoting the value to be enqueued.

Constraints

It is guaranteed that a valid answer always exists for each query of type .
Output Format

For each query of type , print the value of the element at the front of the queue on a new line.

Sample Input

10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2
Sample Output

14
14
Explanation

We perform the following sequence of actions:

Enqueue ; .
Dequeue the value at the head of the queue, ; .
Enqueue ; .
Print the value at the head of the queue, ; .
Enqueue ; .
Print the value at the head of the queue, ; .
Enqueue ; .
Enqueue ; .
Dequeue the value at the head of the queue, ; .
Dequeue the value at the head of the queue, ; .
    * @param args
    */
  def main(args: Array[String]): Unit = {

    val sc = new java.util.Scanner (System.in)
    var n = sc.nextInt()
    var arr = new Array[Int](n)
    val q = Queue


    var etrs: List[(Int, Int)] = List()

    for(i <- 0 to n-1){

      val action = sc.nextInt()
      val map = if(action == 2 || action == 3){
        (action -> 0)
      }else{
        (action -> sc.nextInt())
      }

      etrs = map :: etrs

    }

    etrs = etrs.reverse

    etrs map {
      case (1,v) => q add v
      case (2,0) => q.pop
      case (3,v) => println(q.peek)
    }
  }

  object Queue {

    val qStack = new Stack[Int]()
    val dqStack = new Stack[Int]()

    def add(e: Int) = qStack add e

    def checkEl() = {
      if(dqStack.isEmpty && qStack.isEmpty) throw new NoSuchElementException
      else if(dqStack.isEmpty && !qStack.isEmpty) for(i <- reverseCollect()){
        dqStack add i
      }
    }


    def pop(): Int = {
      checkEl
      dqStack.pop
    }

    def peek(): Int = {

      checkEl
      dqStack.peek

    }


    def reverseCollect(): List[Int] = {

      if(qStack.isEmpty) List()
      else qStack.pop :: reverseCollect()

    }

  }
}
