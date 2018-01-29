package trampoline;

import static trampoline.TailCalls.call;
import static trampoline.TailCalls.done;

public class Trampoline {

  public static void main(String[] args){

    TailCall<Integer> tc = factorialTailRec(1,3);

    System.out.println(tc.invoke());

  }

  public static TailCall<Integer> factorialTailRec(
      final int factorial, final int number) {
    if (number == 1)
      return done(factorial);
    else
      return call(() -> factorialTailRec(factorial * number, number - 1));
  }
}
