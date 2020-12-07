package cs2030.simulator;

import java.util.Optional;

/**
 * DoneEvent to simulate the completion of service to a customer by a server.
 */
public class DoneEvent extends Event {
    protected final Counter server;

    /**
     * Creates Done event.
     * @param customer is the customer involved in the event
     * @param time is the current time
     * @param server is the server involved in the event
     */
    public DoneEvent(Customer customer, double time, Counter server) {
        super(customer, time, shop -> {
            Counter updatedServer = shop.find(shop2 -> shop2.equals(server)).get();
            
            // if the server should rest, update the Counter to be type Server
            // and get the rest time and update the server with the rest time
            if (updatedServer.shouldRest()) {
                Server humanServer = (Server) updatedServer;
                double restTime = humanServer.getRestPeriod();

                return Pair.of(shop.replace(humanServer.rest(restTime)),
                        new ServerRestEvent(customer, time, restTime, humanServer.id));
            } else {
                return Pair.of(shop.replace(updatedServer.done()), null);
            }
        });
        this.server = server;
    }

    @Override
    public String toString() {
        return String.format("%.3f", time) + " " 
            + customer.print() + " done serving by "
                + server.print();
    }
}

