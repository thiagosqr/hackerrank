package tyro;

import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.LongStream;

public class Solution {

  public static void main(String[] args){

    System.out.println(differentTeams("pcmpcmbbbzz"));

  }

  static int differentTeams(final String skills){

    final java.util.function.Function<String, java.util.function.IntPredicate> hasChar =
        s -> i -> Character.toString((char)i).equalsIgnoreCase(s);

    final Long p = skills.chars().filter(hasChar.apply("p")).count();
    final Long c = skills.chars().filter(hasChar.apply("c")).count();
    final Long m = skills.chars().filter(hasChar.apply("m")).count();
    final Long b = skills.chars().filter(hasChar.apply("b")).count();
    final Long z = skills.chars().filter(hasChar.apply("z")).count();

    return Long.valueOf(java.util.stream.LongStream.of(p,c,m,b,z).sorted().findFirst().getAsLong()).intValue();
  }

}
