package datastructure.stacks.balancedbrackets

import scala.Char

/**
  * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line.

Input Format

The first line contains a single integer, , denoting the number of strings.
Each line  of the  subsequent lines consists of a single string, , denoting a sequence of brackets.

Constraints

, where  is the length of the sequence.
Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).
Output Format

For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print YES; otherwise, print NO.

Sample Input

3
{[()]}
{[(])}
{{[[(())]]}}
Sample Output

YES
NO
YES
Explanation

The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced.
The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
  *
  * Created by thiago on 27/09/16.
  */
object Solution extends App {

  val sc = new java.util.Scanner (System.in)
  val strings = readString(sc.nextInt)

  val b  = Map('{' -> '}', '(' -> ')', '[' -> ']')

  val balanced = for {
    s <- strings
    if(isBalanced(s))
  } yield s

  strings.foreach(s => if(balanced.contains(s)) println("YES") else println("NO"))




  def findClosing(s: String, tail: String, open: Char, z: Int): Int = {

    val h = tail.head

    val indexAction = h match {
      case open => z + 1
      case ')' | '}' | ']' => z - 1
      case _ => z
    }

    if (tail.tail.isEmpty) -1 //ran out os chars and could not find a closing bracket
    else if (b(open) == h && z == 0) s.indexOf(tail) // is the immediate closing bracket
    else findClosing(s, tail.tail, open, indexAction) //jump to next char but keep closing index for same open chars

  }


  def isBalanced(s: String): Boolean = {

    val closing = findClosing(s, s.tail, s.head, 0)

    if(closing == -1) false
    else


    //if -1 then unbalanced
    //Tail can only have remaining chars if closing char if directly followed by open char

    true

  }



  def readString(n: Int): List[String] =
    if(n > 0) sc.next.trim :: readString(n-1)
    else List()

}
