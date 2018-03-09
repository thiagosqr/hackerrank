package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class IceCreamParlor {

  static void solve(int[] arr, int money) {

    Arrays.sort(arr);

    int right = arr.length-1;
    int left = 0;
    int fixed = right;
    int foundAt = 0;

    while(foundAt == 0){

      int midArray = left+right / 2;

      if(arr[fixed] >= money || left >= right){
        fixed--;
        left = 0;
        right = fixed;

      }else{
          if(arr[midArray] + arr[fixed] > money){
            right = midArray > 0? midArray-1 : 0;
          }else if(arr[midArray] + arr[fixed] < money){
            left = midArray+1;
          }else{
            foundAt = midArray;
            break;
          }

        if(arr[left] + arr[fixed] == money){
          foundAt = left;
          break;
        }else if(arr[right] + arr[fixed] == money){
          foundAt = right;
          break;
        }

      }

    }

    System.out.println(foundAt+" "+fixed);
    System.out.println(arr[foundAt]  + arr[fixed]);

  }

  public static void main(String[] args){
//    solve(new int[]{1,3,8,6,2,3,9,22,1,5,4,3},17);
//    solve(new int[]{11,13,8,16,12,13,9,22,11,15,14,13},17);
//    solve(new int[]{1, 4, 5, 3, 2},5);
//    solve(new int[]{2,2,5,3},4);

//    Scanner in = new Scanner(System.in);
//
//    int money = in.nextInt();
//    int n = in.nextInt();
//    int[] arr = new int[n];
//    for(int arr_i = 0; arr_i < n; arr_i++){
//      arr[arr_i] = in.nextInt();
//    }
//    solve(arr, money);

  }
}
