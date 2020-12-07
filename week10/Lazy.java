// not allowed to use null 
// not allowed to use isPresent(), isEmpty(), or get() methods of the Optional class 
// not allowed to use looping: for, while, and do

// The first time the value is computed, a cached copy is stored. 
// Can no longer define the cache as private final. 

import java.util.Objects;
import java.util.function.Supplier;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.NoSuchElementException;
import java.util.stream.Stream;


public class Lazy<T extends Comparable<T>>{
    private T t;
    private Supplier<? extends T> supplier;
    private boolean available;

    public Lazy(T t) {
        this.t = t;
        this.available = true;
    }

    public Lazy(Supplier<? extends T> supplier) {
        this.t = t;
        this.supplier = supplier;
        this.available = false;
    }


    public T get() {   
        if (!(this.available)) {
            this.t = this.supplier.get();
           
            // if this.t is null, throw java.lang.NullPointerException
            Optional.of(this.t).orElseThrow(NullPointerException::new);  

            this.available = true;
        }

        return this.t;        
    }


    public static <T extends Comparable<T>> Lazy<T> of(T v) {
        // this should still be lazy and return "?" until .get() is used 
        return new Lazy<T>(() -> v);
    }

    public static <T extends Comparable<T>> Lazy<T> of(Supplier<T> s) {

        // exception thrown when passing a null to of()
        Optional.ofNullable(s).orElseThrow(() ->
                new NoSuchElementException("No value present"));

        return new Lazy<T>(s);
        // return new Lazy<T>(Objects.requireNonNull(s));
    }


    public <R extends Comparable<R>> Lazy<R> map(Function<? super T, ? extends R> function) {
        return new Lazy<R>(() -> function.apply(get()));
    }

    public <R extends Comparable<R>> Lazy<R> flatMap(Function<? super T, ? extends Lazy<? extends R>> function) {
        return new Lazy<R>(() -> function.apply(get()).get());
    }


    public <U extends Comparable<U>, R extends Comparable<R>> Lazy<R> combine(Lazy<U> lazy, BiFunction<T,U,R> function) {
        return new Lazy<R>(() -> function.apply(get(), lazy.get()));
    }


    public Lazy<Boolean> test(Predicate<T> p) {
        return new Lazy<Boolean>(() -> p.test(get()));
    }

    public Lazy<Integer> compareTo(Lazy<T> lazy) {
        return new Lazy<Integer>(() -> get().compareTo(lazy.get()));
    }


    @Override
    public boolean equals(Object other){
        if (other instanceof Lazy<?>){ 
            return get().equals( ((Lazy<?>)other).get());
        }
        return false;
    }


    @Override 
    public String toString() {
        if (this.available) {           
            return String.valueOf(this.t);
        } else {
            return "?";
        }
    }

}

