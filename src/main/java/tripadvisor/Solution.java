package tripadvisor;

import java.util.function.Function;

public class Solution {

  public static void main(String[] args){
    System.out.println(findLargestAbsolutePrimeInRange(100));
  }


  static boolean isPrime(int n){
    boolean notPrime = false;
    if(n != 1){
      for(int j = 2;j * j <= n;j++){
        if(n % j == 0){
          notPrime = true;
          break;
        }
      }
    }
    return !notPrime;
  }

  static int findLargestAbsolutePrimeInRange(int maximum) {

    int biggestSum = Integer.MIN_VALUE;
    int biggestPrime = Integer.MIN_VALUE;

    for(int i = 2;i < maximum;i++){
      if(isPrime(i)){
        char[] digits =  String.valueOf(i).toCharArray();
        int sum = 0;
        for(int j = 0;j < digits.length;j++){
            int digit = Character.getNumericValue(digits[j]);
            sum  = sum+digit;
        }

        if(sum > biggestSum){
          biggestSum = sum;
          biggestPrime = i;
        }

      }
    }

    return biggestPrime;
  }

}
