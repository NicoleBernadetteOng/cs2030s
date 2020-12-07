package cs2030.simulator;

/**
 * ServerRestEvent when a server rests.
 */
public class ServerRestEvent extends Event {
    private final int serverId;

    /**
     * Creates ServerRestEvent.
     * @param customer customer involved in the event 
     * @param time current time
     * @param restTime rest time of the server
     * @param serverId id of the server
     */
    public ServerRestEvent(Customer customer, double time, double restTime, int serverId) {
        super(customer, time, shop -> Pair.of(shop, 
            new ServerBackEvent(customer, time + restTime, serverId)));
        this.serverId = serverId;
    }
}