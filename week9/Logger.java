import java.util.function.Function;
import java.util.function.Predicate;

public interface Logger<T> {

    public static <T> Logger<T> make(T value) {
        // if t is null, throw java.lang.IllegalArgumentException: 
        // argument cannot be null
        if (value == null) {
            throw new IllegalArgumentException("argument cannot be null");
        }

        // if Logger.make(Logger.make(7)) already a logger 
        // throw java.lang.IllegalArgumentException: already a Logger
        if (value instanceof Logger) {
            throw new IllegalArgumentException("already a Logger");
        }

        return new LoggerImpl<T>(value);
    }

    public void printlog();

    public <R> Logger<R> map(Function<? super T, ? extends R> function);

    public <R> Logger<R> flatMap(Function<? super T, ? extends Logger<? extends R>> function);

    // test method that takes in a Predicate and returns true or false
    public boolean test(Predicate<T> pred);

    // function f that takes in n and returns a Logger<Integer> that wraps around a final
    // value 
}

