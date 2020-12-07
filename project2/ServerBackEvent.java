package cs2030.simulator;

/**
 * ServerBackEvent when a server returns. 
 */
public class ServerBackEvent extends Event {
    /**
     * Creates ServerBackEvent.
     * @param customer customer involved in the event
     * @param time current time
     * @param serverId id of the server serving the customer
     */
    public ServerBackEvent(Customer customer, double time, int serverId) {
        super(customer, time, shop -> {
            Counter server = shop.find(shop2 -> shop2.id == serverId).get();
            return Pair.of(shop.replace(server.done()), null);
        });
    }
}