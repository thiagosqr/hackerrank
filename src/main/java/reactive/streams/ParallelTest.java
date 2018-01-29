package reactive.streams;

import rx.Observable;
import rx.schedulers.Schedulers;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ParallelTest {

  private static final Random rand = new Random();

  public static void main(String[] args) {

    final Observable<Integer> range = new RxRange(1, 2500).toObservable();

    final ThreadPoolExecutor publisherPool = new ThreadPoolExecutor(2,2,10, TimeUnit.SECONDS, new ArrayBlockingQueue(1));

    final ThreadPoolExecutor consumerPool = new ThreadPoolExecutor(5,5,10, TimeUnit.SECONDS, new ArrayBlockingQueue(1));

    Observable<Integer> vals = Observable.range(1,100);

    range.subscribeOn(Schedulers.newThread()) //??
        .flatMap(val -> Observable.just(val)
        .subscribeOn(Schedulers.computation())
        .map(i -> intenseCalculation(i))
    ).observeOn(Schedulers.from(consumerPool), 5)
     .subscribe(val -> {

      System.out.println("Subscriber received "
          + val + " on "
          + Thread.currentThread().getName());

//       try {
//         Thread.sleep(randInt(1000,5000));
//       } catch (InterruptedException e) {
//         throw new RuntimeException(e);
//       }

    });

    waitSleep();
  }
  public static void waitSleep() {
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  public static int intenseCalculation(int i) {
    try {
//      System.out.println("Calculating " + i + " on " + Thread.currentThread().getName());
      Thread.sleep(randInt(1000,5000));
      return i;
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static int randInt(int min, int max) {
    return rand.nextInt((max - min) + 1) + min;
  }
}