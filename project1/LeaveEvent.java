package cs2030.simulator;

import java.util.List;
import java.util.ArrayList;

class LeaveEvent extends Event {
    private final List<Server> servers = new ArrayList<>();
    private final Server server;

    /** 
     * Creates an LeaveEvent.
     * @param customer customer that the event is acting on
     * @param time time that the event is created
     */
    public LeaveEvent(Customer customer, List<Server> servers,
            Server server, double time) {
        super(customer, servers, time);
        this.server = server;
    }
    
    // when the customer leaves, nothing really happens 
    // return a dummy FinishEvent 
    public Event execute() {
        Customer customer = this.getCustomer();
        double time = this.getTime();
        return new FinishEvent(customer, servers, server, time);
    }

    @Override
    public String toString() {
        return String.format("%.3f",this.getTime()) +
            ' ' + this.getCustomerId() + " leaves";
    }

}

