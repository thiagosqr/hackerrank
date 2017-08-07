import java.util.Optional;

/**
 * Created by thiago on 18/07/17.
 */
public class MonadicExample {

    class Foo {
        public Optional<Bar> bar(){
            return Optional.of(new Bar());
        }
    }

    class Bar {
        public Optional<Baz> baz(){
            return Optional.of(new Baz());
        }
    }

    class Baz{
        public Integer compute(){
            return 1;
        }
    }

    public static void main(String[] args){

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


}
