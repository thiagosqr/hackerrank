import java.util.stream.Stream;

public class Trampoline {


  @FunctionalInterface
  public interface TailCall<T> {
    TailCall<T> apply();
    default boolean isComplete() { return false; }
    default T result() { throw new Error("not implemented"); }
    default T invoke() {
      return Stream.iterate(this, TailCall::apply)
          .filter(TailCall::isComplete)
          .findFirst()
          .get()
          .result();
    }
  }

  public class TailCalls {
    public static <T> TailCall<T> call(final TailCall<T> nextCall) {
      return nextCall;
    }
    public static <T> TailCall<T> done(final T value) {
      return new TailCall<T>() {
        @Override public boolean isComplete() { return true; }
        @Override public T result() { return value; }
        @Override public TailCall<T> apply() {
          throw new Error("not implemented");
        }
      };
    }
  }
}
