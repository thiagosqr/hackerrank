package datastructures;

public class Primality2 {

  public static void main(String[] args){

    System.out.println(isPrime(3));

  }



  public static boolean isPrime(Integer n){
    if(n == 1){
      return false;
    }else{


      if(n % Math.sqrt(n) == 0) return false;

//      for(int i = 2; i * i<= n;i++){
//          if(n % i == 0) return false;
//      }
    }

    return true;
  }
}
