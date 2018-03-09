package reactive.streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import rx.Observable.OnSubscribe;
import rx.*;
import rx.internal.operators.BackpressureUtils;
import rx.schedulers.Schedulers;

public final class RxRange implements OnSubscribe<Integer> {
  final int start;
  final int count;
  public RxRange(int start, int count) {
    if (count < 0) {
      throw new IllegalArgumentException();
    }
    this.start = start;
    this.count = count;
  }
  @Override
  public void call(Subscriber<? super Integer> t) {
    if (count == 0) {
      t.onCompleted();
      return;
    }
    RangeProducer p = new RangeProducer(t, start, count);
    t.setProducer(p);
  }

  public Observable<Integer> toObservable() {
    return Observable.create(this);
  }

  static final class RangeProducer extends AtomicLong implements Producer {
    /** */
    private static final long serialVersionUID = 5318571951669533517L;
    final Subscriber<? super Integer> child;
    int index;
    int remaining;
    public RangeProducer(Subscriber<? super Integer> child, int start, int count) {
      this.child = child;
      this.index = start;
      this.remaining = count;
    }
    @Override
    public void request(long n) {

      final String td = Thread.currentThread().getName();
      System.out.println(td+" Requested "+n);

      if (n < 0) {
        throw new IllegalArgumentException();
      }
      if (n == 0) {
        return;
      }
      if (BackpressureUtils.getAndAddRequest(this, n) != 0) {
        return;
      }
      long r = n;
      for (;;) {
        if (child.isUnsubscribed()) {
          return;
        }
        int i = index;
        int k = remaining;
        int e = 0;

        while (r > 0 && k > 0) {

          try {
            Thread.sleep(200);
          } catch (InterruptedException ignored) {
            // can be ignored, just used for pausing
          }

          child.onNext(i);

          final String ptd = Thread.currentThread().getName();
          System.out.println(ptd+" Published "+i);

          if (child.isUnsubscribed()) {
            return;
          }
          k--;
          if (k == 0) {
            child.onCompleted();
          }
          e++;
          i++;
          r--;
        }
        index = i;
        remaining = k;

        r = addAndGet(-e);

        if (r == 0) {
          final String ptd = Thread.currentThread().getName();
          System.out.println(ptd+" Ending request");
          return;
        }
      }

    }
  }

  public static void main(String[] args) {

    final Observable<Integer> range = new RxRange(1, 250).toObservable();

//    range.subscribe(
//        System.out::println,
//        Throwable::printStackTrace,
//        () -> System.out.println("Done")
//    );



    final ThreadPoolExecutor publisherPool = new ThreadPoolExecutor(5,5,10,TimeUnit.SECONDS, new ArrayBlockingQueue(1));
    final ThreadPoolExecutor consumerPool = new ThreadPoolExecutor(5,5,10,TimeUnit.SECONDS, new ArrayBlockingQueue(1));

    range.subscribeOn(Schedulers.newThread())
        .flatMap(v -> Observable.just(v)
          .subscribeOn(Schedulers.from(publisherPool))
          .map(i -> {
            System.out.println("Mapping "+i+" on "+Thread.currentThread().getName());
            try {
              Thread.sleep(200);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            return i;
          })
        )

        //         .subscribeOn(Schedulers.newThread())
//        .observeOn(Schedulers.from(consumerPool))
        .subscribe(new Subscriber<Integer>() {
          @Override
          public void onStart() {
            final String td = Thread.currentThread().getName();
            System.out.println(td + " OnStart");
          }

          @Override
          public void onCompleted() {
            final String td = Thread.currentThread().getName();
            System.out.println(td+"OnCompleted");
          }

          @Override
          public void onError(Throwable e) {
            e.printStackTrace();
          }

          @Override
          public void onNext(Integer n) {
            final String td = Thread.currentThread().getName();

            try {
                        final URL url = new URL(
                            "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22YHOO%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=");
                        final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
              //          final String data = reader.lines().skip(1).findFirst().get();
              //          final String[] dataItems = data.split(",");
              //          final BigDecimal stock = new BigDecimal(dataItems[dataItems.length - 1]);
              //
              System.out.println(td+" APPL: $1.00 for "+n);

              //          System.out.println(publisherPool.getActiveCount()+" Active threads");

//              Thread.sleep(1000);

            } catch(Exception ex) {
              ex.printStackTrace();
            }
          }
        });

    try {
      Thread.sleep(50000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}