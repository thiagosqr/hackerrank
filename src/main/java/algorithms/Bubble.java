package algorithms;

import java.util.Scanner;

public class Bubble {


  public static void main(String[] args){

//    Scanner in = new Scanner(System.in);
//    int t = in.nextInt();
//
//    Integer[] arr = new Integer[t];
//
//    for (int i = 0; i < t; i++) {
//      arr[i] = in.nextInt();
//    }

    Integer[] arr = new Integer[]{3,2,1};

    int iteratios = 0;
    int lastSorted = arr.length-1;
    boolean sorted = false;

    while(!sorted){
      sorted = true;
      for(int j = 0;j < lastSorted;j++){
          if(arr[j] > arr[j+1]){
            iteratios++;
            sorted=false;
            int temp = arr[j+1];
            arr[j+1] = arr[j];
            arr[j] = temp;
          }

      }
      lastSorted--;
    }

    System.out.println(String.format("Array is sorted in %s swaps.", iteratios));
    System.out.println("First Element: "+arr[0]);
    System.out.println("Last Element: "+arr[arr.length-1]);

  }

}
