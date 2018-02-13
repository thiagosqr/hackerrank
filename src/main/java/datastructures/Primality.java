package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Primality {

  public static void main(String[] args){

    final List<Integer> l = Arrays.asList(1,
        4,
        9,
        3);

    l.stream().map(i -> {
      boolean notPrime = false;
      if(i == 1){
        return "Not prime";
      }else{
        for(int j = 2;j * j <= i;j++){
          if(i % j == 0){
            notPrime = true;
            break;
          }
        }
        return notPrime? "Not prime":"Prime";
      }
    }).forEach(i -> System.out.println(i));

  }


}
