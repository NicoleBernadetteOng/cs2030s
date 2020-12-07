import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.UnaryOperator;

class LazyList<T extends Comparable<T>> {
    private List<Lazy<T>> list;
    private UnaryOperator<T> f;

    private LazyList(List<Lazy<T>>list, UnaryOperator<T> f) {
        this.list = list;
        this.f = f;
    }

    // n is the size of the list 
    // seed is the initial value 
    // f is an operation
    static <T extends Comparable<T>> LazyList<T> generate(int n, T seed, UnaryOperator<T> f) {
        List<Lazy<T>> list = new ArrayList<>();
        list.add(Lazy.of(seed));
        return new LazyList<T>(list, f);
    }

    // get the last index of the list 
    // if the int i is more than last index 
    // start Stream.iterate 
    public T get(int i) {
        int lastIndex = this.list.size() - 1;
        if (i > lastIndex) {
            Stream.iterate(this.f.apply(this.list.get(lastIndex).get()), x -> this.f.apply(x))
                .limit(i - lastIndex)
                .forEach(x -> this.list.add(Lazy.of(x)));
        }

        return this.list.get(i).get();
    }


    public int indexOf(T v) {
        List<T> values = this.list.stream()
            .map(lazy -> lazy.get())
            .collect(Collectors.toList());

        if (values.indexOf(v) < 0) {
            get(this.list.size());
            return indexOf(v);
        }

        return values.indexOf(v);
    }

}
