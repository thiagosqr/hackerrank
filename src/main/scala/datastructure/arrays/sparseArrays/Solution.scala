package datastructure.arrays.sparseArrays

/**
  * Created by thiago on 9/8/16.
  * There are  strings. Each string's length is no more than  characters. There are also  queries. For each query, you are given a string, and you need to find out how many times this string occurred previously.

Input Format

The first line contains , the number of strings.
The next  lines each contain a string.
The nd line contains , the number of queries.
The following  lines each contain a query string.

Constraints


Sample Input

4
aba
baba
aba
xzxb
3
aba
xzxb
ab
Sample Output

2
1
0
Explanation

Here, "aba" occurs twice, in the first and third string. The string "xzxb" occurs once in the fourth string, and "ab" does not occur at all.
  */
object Solution extends App{

  val sc = new java.util.Scanner (System.in)
  val strings = readString(sc.nextInt)
  val queries = readString(sc.nextInt)
  val queriesD = queries.distinct
  val results = for(q <- queriesD; s <- strings if(s equals q)) yield q
  val nonOccurs = queriesD.filterNot(results.distinct.contains(_))
  var resMapped = results.groupBy(_.toString) ++ nonOccurs.map(_ -> List())

  for(q <- queries) println(resMapped(q).length)

  def readString(n: Int): List[String] =
    if(n > 0) sc.next.trim :: readString(n-1)
    else List()

}
