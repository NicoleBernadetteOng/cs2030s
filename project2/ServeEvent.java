package cs2030.simulator;

import java.util.Optional;

/**
 * ServeEvent class to simulate the start of service to a customer by a server.
 */
class ServeEvent extends Event {
    private final Counter server;

    /**
     * Initialises Serve event.
     * @param customer is the customer involved in the event
     * @param time is the current time
     * @param server is the server involved in the event
     */
    public ServeEvent(Customer customer, double time, Counter server) {
        super(customer, time, shop -> {
            Counter updatedServer = shop.find(shop2 -> shop2.equals(server)).get();

            if (updatedServer.hasWaitingCustomer() && updatedServer.nextAvailableTime > time) {
                if (!server.isHuman()) {
                    updatedServer = shop.fastestSelfCheckout();
                }
                return Pair.of(shop, new ServeEvent(customer, updatedServer.nextAvailableTime,
                        updatedServer));
            } else {
                return Pair.of(shop.replace(updatedServer.serve(time + customer.getServiceTime())),
                        new DoneEvent(customer, time + customer.getServiceTime(), updatedServer));
            }
        });
        this.server = server;
    }

    @Override
    public String toString() {
        return String.format("%.3f", time) + " " 
            + customer.print() + " served by " 
                + server.print();
    }
}
