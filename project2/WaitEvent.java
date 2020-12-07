package cs2030.simulator;

/**
 * WaitEvent class to simulate the act of customer waiting.
 */
public class WaitEvent extends Event {
    private final Counter server;

    /**
     * Initialises Wait event.
     * @param customer is the customer involved in the event
     * @param time is the current time
     * @param server is the server involved in the event
     */
    public WaitEvent(Customer customer, double time, Counter server) {
        super(customer, time, shop -> {
            // if the server is human, get a server, otherwise get the fastest selfCheckout
            Counter updatedServer = server.isHuman() ? 
                shop.find(shop2 -> shop2.equals(server)).get() : shop.fastestSelfCheckout();

            return Pair.of(shop.replace(updatedServer.makeWait()),
                    new ServeEvent(customer, updatedServer.nextAvailableTime, updatedServer));
        });
        this.server = server;
    }

    @Override
    public String toString() {
        return String.format("%.3f", customer.getTime()) 
            + " " + customer.print() + 
            " waits to be served by " + server.waitingNow();
    }
}

