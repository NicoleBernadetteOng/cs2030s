package cs2030.simulator;

import java.util.function.Function;

/**
 * Abstract Event class to enforce polymorphism.
 * subclasses can create the next event and update statistics.
 */
public abstract class Event {

    protected final Customer customer;
    protected final int serverId;
    protected final double time;
    private final Function<Shop, Pair<Shop, Event>> func;

    Event(Customer customer, double time) {
        this.customer = customer;
        this.serverId = 1;
        this.time = time;
        this.func = shop -> new Pair<Shop,Event>(shop, null);
    }

    Event(Customer customer, int serverId, double time, Function<Shop, Pair<Shop, Event>> func) {
        this.customer = customer;
        this.serverId = serverId;
        this.time = time;
        this.func = func;
    }

    Event(Customer customer, double time, Function<Shop, Pair<Shop, Event>> func) {
        this.customer = customer;
        this.serverId = 1;
        this.time = time;
        this.func = func;
    }

    final Pair<Shop, Event> execute(Shop shop) { // declared final to avoid overriding
        return this.func.apply(shop); // func is the Function property
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public int getCustomerId() {
        return this.customer.getCustomerId();
    }

    public double getTime() {
        return this.time;
    }

    public int getServerId() {
        return this.serverId;
    }

}

