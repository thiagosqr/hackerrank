import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by thiago on 18/07/17.
 */
public class MonadicExample {

    public static void main(String[] args){

        MonadicExample f = new MonadicExample();
//        Integer i = f.compute(Optional.of(new Foo())).orElse(1);
//        System.out.println(i);

        CompletableFuture<Integer> j = f.compute(CompletableFuture.supplyAsync(() -> new Foo()));
        System.out.println(j.join());

    }


    public Optional<Integer> compute(Optional<Foo> possible){
        return possible.flatMap(foo ->
            foo.bar().flatMap(bar ->
                bar.baz().map(baz ->
                    baz.compute()
                )
            )
        );

    }

    public CompletableFuture<Integer> compute(CompletableFuture<Foo> possible){
        return possible
            .thenApply(foo -> foo.csBar())
            .thenApply(bar -> bar.csBaz())
            .thenApply(baz -> baz.compute())
            .exceptionally(e -> 1);
    }



}

class Foo {
    public Optional<Bar> bar(){
        return Optional.of(new Bar());
    }

    public Bar csBar(){
//        return CompletableFuture.completedFuture(new Bar());
        return new Bar();
    }
}

class Bar {
    public Optional<Baz> baz(){
        return Optional.of(new Baz());
    }

    public Baz csBaz(){
        return new Baz();
    }
}

class Baz{
    public Integer compute(){
        return 1;
    }
}
