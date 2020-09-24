import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.*;

class ImmutableList<T> {
    private final List<T> list;

    // the resulting list is not modifiable 
    public ImmutableList(List<T> someList) {
        this.list = List.copyOf(someList);;
    }

    @SafeVarargs 
    public ImmutableList(T... items) {
        List<T> temp = new ArrayList<>(items.length);
        for (T i : items) {
            temp.add(i);
        }
        this.list = temp;
    }


    public ImmutableList<T> add(T t) {
        List<T> newList = new ArrayList<>(this.list);
        newList.add(t);
        return new ImmutableList<T>(newList);
    }


    public ImmutableList<T> remove(T t) {
        List<T> newList = new ArrayList<>(this.list);
        newList.remove(t);
        return new ImmutableList<T>(newList);
    }


    public ImmutableList<T> replace(T tOld, T tNew) {
        List<T> newList = new ArrayList<>(this.list);
        Collections.replaceAll(newList, tOld, tNew);
        return new ImmutableList<T>(newList);
    }


    public ImmutableList<T> limit(long newSize) {
        if (newSize < 0) {
            throw new IllegalArgumentException("limit size < 0");
        } else {
            List<T> newList = new ArrayList<>(this.list);
            long oldSize = newList.size();

            for(int i = 0; i < oldSize - newSize; i++) {
                newList.remove(newList.size() - 1);
            }         
            return new ImmutableList<T>(newList);
        }
    }


    public static boolean areAllTrue(boolean[] array) {
        for (boolean b : array) {
            if(!b) {
                return false;
            }
        }
        return true;
    }


    public boolean equals(ImmutableList<T> other) {
        if (this.list.size() == other.list.size()) {
            boolean[] boolList = new boolean[this.list.size()];

            for (int i = 0; i < other.list.size(); i++) {
                if (this.list.get(i) == other.list.get(i)) {
                    boolList[i] = true;
                } else {
                    boolList[i] = false;
                }
            }
            return areAllTrue(boolList);
        } else {
            return false;
        }
    }


    public ImmutableList<T> sorted(Comparator<T> com) {
        if (com == null) {
            throw new NullPointerException("Comparator is null");
        }
        List<T> newList = new ArrayList<>();
        for (T i : this.list) {
            newList.add(i);
        }
        newList.sort(com);
        return new ImmutableList<T>((List<T>) newList);
    }


    public Object[] toArray() {
        Object[] array = this.list.toArray();
        return array;
    }


    public <U> U[] toArray(U[] array) {
        try {
            return this.list.toArray(array);
        } catch (ArrayStoreException e) {
            throw new ArrayStoreException("Cannot add element to array as " +
                    "it is the wrong type");
        } catch (NullPointerException n) {
            throw new NullPointerException("Input array cannot be null");
        }
    }


    // BONUS
    public ImmutableList<T> filter(Predicate<? super T> p) {
        List<T> newList = new ArrayList<>();
        for (T i: this.list) {
            if (p.test(i)) {
                newList.add(i);
            }
        }
        return new ImmutableList<T>(newList);
    }

    public <R> ImmutableList<R> map(Function<? super T, ? extends R> fun) {
        List<R> newList = new ArrayList<>();
        for (T i: this.list) {
            newList.add(fun.apply(i));
        }
        return new ImmutableList<R>(newList);
    }


    @Override 
    public String toString() {
        return this.list.toString(); 
    }
}
