package cs2030.simulator;

public class Pair<T, U> {
    private final T t; 
    private final U u;
    
    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public static <T, U> Pair<T, U> of(T t, U u) {
        return new Pair<T, U>(t, u);
    }
    
    public T first() {
        return this.t;
    }

    public U second() {
        return this.u;
    }

}
