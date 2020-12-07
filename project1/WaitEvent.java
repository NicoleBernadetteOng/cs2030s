package cs2030.simulator;

import java.util.List;

/**
 * WaitEvent class to simulate the act of customer waiting.
 */
public class WaitEvent extends Event {
    private final Server server;
    
    public WaitEvent(Customer customer, List<Server> servers,
            Server server, double time) {
        super(customer, servers, time);
        this.server = server;
    }

    /**
     * Method to execute the Event.
     */
    public Event execute() {
        Customer customer = this.getCustomer();
        List<Server> newServers = this.getServers();
        // Server server = this.getServer();
        double time = this.getTime();
        double nextAvailableTime = this.server.getNextAvailableTime();

        if (server.canTakeWaitEvent()) { 
            // Server updatedServer = new Server(server.getServerId(), 
            //         false, true, time);
            Server updatedServer = new Server(server.getServerId(),
                    false, true, time);

            newServers.set(server.getServerId() - 1, updatedServer);

            return new ServeEvent(customer, newServers, server, nextAvailableTime);

        } else {
            return new LeaveEvent(customer, newServers, server, time);
        }
    }

    /**
     * Method to return string of WaitEvent when instantiated.
     * @return returns string of WaitEvent 
     */
    public String toString() {
        return (String.format("%.3f",this.getTime()) +
                ' ' + this.getCustomerId() + " waits to be served by " +
                this.server.getServerId());
    }

}

