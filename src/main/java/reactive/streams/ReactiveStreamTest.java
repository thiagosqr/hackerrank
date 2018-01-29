package reactive.streams;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerObserverArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class ReactiveStreamTest {

  public static void main(String[] args){

    final CountDownLatch countDownLatch = new CountDownLatch(20);

    final Observable<Long> o = Observable.create(s -> {

      Producer producer = n -> {

        final List<Long> longs = new ArrayList<>();

        for(long l = 0; l < n; l++){
          longs.add(countDownLatch.getCount());
          countDownLatch.countDown();
        }

        try{

          if(countDownLatch.getCount() == 10){
            throw new RuntimeException();
          }else if(countDownLatch.getCount() == 5){
            System.out.println("Completing "+countDownLatch.getCount());
            s.onCompleted();
          }

          Thread.sleep(1000);

          if(s.isUnsubscribed()){
            s.onCompleted();
          }else{
            System.out.println("Producing "+ n);
            longs.stream().forEach(ls -> s.onNext(ls));
          }

        }catch (Exception e){
          s.onError(e);
        }

      };

      s.setProducer(producer);

    });


    o.subscribe(new Subscriber<Long>() {
      @Override
      public void onStart() {
        System.out.println("OnStart");
        System.out.println("Requesting First");
        request(1);
      }

      @Override
      public void onCompleted() {
        System.out.println("OnCompleted");
      }

      @Override
      public void onError(Throwable e) {
        System.out.println("OnError");
      }

      @Override
      public void onNext(Long n) {
        System.out.println("Processing " + n);
        System.out.println("Requesting");
        request( new Integer(new Random().nextInt(5)).longValue());
      }
    });

  }

}
