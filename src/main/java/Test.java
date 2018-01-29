import java.util.function.Function;

public class Test {

  private int x = 0;

  public static void main(final String[] args) {

      Test t = new Test();

      System.out.println(t.x);
      change(t);
      System.out.println(t.x);

  }


  public static void change(Test t){

    t = new Test();
    t.x = 1;

  }
}
