package atla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindList {
  public static void main(String[] args) {

    //    Scanner sc = new java.util.Scanner(System.in);
    //    int listSize = sc.nextInt();
    //    Integer[] stList = new Integer[listSize];
    //    for (int i = 0; i < listSize; i++) {
    //      stList[i] = sc.nextInt();
    //    }
    //    listSize = sc.nextInt();
    //    Integer[] ndList = new Integer[listSize];
    //    for (int i = 0; i < listSize; i++) {
    //      ndList[i] = sc.nextInt();
    //    }

    //    System.out.println(find(Arrays.asList(stList), Arrays.asList(ndList)));
//    Scanner sc = new java.util.Scanner(System.in);
//    int start = sc.nextInt();
//    int it = sc.nextInt();
//    System.out.println(lookAndSay(start, it));


     List<String> l = Arrays.asList(new String[]{"ABC","CDE"});

    l = l.stream().flatMap(s -> s.chars().mapToObj(c -> Character.toString((char)c)))
        .filter(c -> c.equals("C"))
        .collect(Collectors.toList());

    System.out.println(l);


  }

  public static Integer lookAndSay(final Integer start, final Integer it) {

    String literal = String.valueOf(start);
    final List<Map<Integer, Integer>> index = new ArrayList<>();

    while (!literal.isEmpty()) {

      int newStart = 0;
      int count = 0;

      for (int i = 0; i < literal.length(); i++) {
        if (literal.charAt(i) == literal.charAt(0)) {
          count++;
          newStart++;
        } else
          break;
      }

      index.add(Collections
          .singletonMap(Character.getNumericValue(literal.charAt(0)), count));

      literal = literal.substring(newStart);

    }

    final String literalIndex = index.stream()
        .map(m -> String.format("%d%d",m.values().iterator().next(),m.keySet().iterator().next()))
        .collect(Collectors.joining(""));

    final Integer r = Integer.parseInt(literalIndex);

    return it > 1? lookAndSay(r,it-1) : r ;

  }


}




