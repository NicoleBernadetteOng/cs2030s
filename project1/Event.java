package cs2030.simulator;

import java.util.List;

/**
 * Abstract Event class to enforce polymorphism.
 * subclasses can create the next event and update statistics.
 */
public abstract class Event {
    private final double SERVICE_TIME = 1.0;
   
    private final Customer customer;
    private final double time;
    private final List<Server> servers;

    /**
     * Event constructor for LeaveEvent.
     * @param customer customer that the event is acting on
     * @param servers list of servers
     * @param time time that the event is created
     */
    public Event(Customer customer, List<Server> servers, double time) {
        this.customer = customer;
        this.servers = servers;
        this.time = time;
    }

    public abstract Event execute();

    public Customer getCustomer() {
        return this.customer;
    }

    public int getCustomerId() {
        return this.customer.getCustomerId();
    }

    public double getTime() {
        return this.time;
    }

    public List<Server> getServers() {
        return this.servers;
    }

}

