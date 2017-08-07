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

  val b  = Map('{' -> '}', '(' -> ')', '[' -> ']').withDefaultValue(' ')

  val balanced = for {
    s <- strings
    if(isBalanced(s))
  } yield s

  strings.foreach(s => if(balanced.contains(s)) println("YES") else println("NO"))


  def findClosing(s: String, tail: String, open: Char, z: Int): Int = {

    val h = tail.head
    val closingChar = b(open)

    //Pattern Matching on Var must be surrounded by backticks
    val indexAction = h match {
      case `closingChar` => z - 1
      case `open` => z + 1
      case _ => z
    }

    //If is closing is the last Char or withing string
    val closingOrLast = if(tail.tail.isEmpty) s.length -1 else s.indexOf(tail)

    if (tail.tail.isEmpty && indexAction > 0) -1 //ran out os chars and could not find a closing bracket
    else if (b(open) == h && indexAction == 0) closingOrLast // is the immediate closing bracket
    else findClosing(s, tail.tail, open, indexAction) //jump to next char but keep closing index for same open chars

  }

  def isBalanced(s: String): Boolean = {

    val startingIndex = if(!s.isEmpty && b(s.head) != null) 1 else 0
    val closingIndex = if(s.isEmpty || s.length == 1) 1 else findClosing(s, s.tail, s.head, startingIndex)
    val isLastChar = s.length - 1 == closingIndex


    if(s.isEmpty) true
    else if(s.length == 1) false
    else if(!isLastChar && closingIndex == 1) isBalanced(s.substring(closingIndex+1))
    else if(!isLastChar && closingIndex > 1) isBalanced(s.substring(0+1,closingIndex) + s.substring(closingIndex+1))
    else if(isLastChar) isBalanced(s.substring(1,closingIndex))
    else false

  }


  def readString(n: Int): List[String] =
    if(n > 0) sc.next.trim :: readString(n-1)
    else List()

}
