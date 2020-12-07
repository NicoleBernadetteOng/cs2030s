package cs2030.simulator;

import java.util.List;

/**
 * FinishEvent to signal the end of a customer getting served.
 */
class FinishEvent extends Event {
    private final double SERVICE_TIME = 1.0;
    private final Server server;

    /**
     * Creates a FinishEvent.
     * @param customer customer that the event is involving
     * @param time time at which event is created
     * @param server server that the FinishEvent belongs to
     */
    public FinishEvent(Customer customer, List<Server> servers,
            Server server, double time) {
        super(customer, servers, time);
        this.server = server;
    }


    public Event execute() {
        return null;
    }

    @Override
    public String toString() {
        return "FinishEvent";
    }
}

