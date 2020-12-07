import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.UnaryOperator;
// a function which takes in one argument and operates on it. However what distinguishes it from a normal Function is that both its argument and return type are the same.

public class NewLazyList<T extends Comparable<T>> {
    private final List<Lazy<T>> list;

    private NewLazyList(List<Lazy<T>> list) {
        this.list = list;
    }

    static <T extends Comparable<T>> NewLazyList<T> generate(int n, T seed, UnaryOperator<T> f) {
        return new NewLazyList<T>(
                Stream.iterate(Lazy.of(seed), x -> x.map(f))
                .limit(n)
                .collect(Collectors.toList())
        );
    }

    public T get(int i) {
        return this.list.get(i).get();
    }

    public int indexOf(T v) {
        return this.list.indexOf(Lazy.of(v));
    }

}

