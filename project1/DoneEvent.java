package cs2030.simulator;

import java.util.List;

/**
 * DoneEvent to simulate the completion of service to a customer by a server.
 */
public class DoneEvent extends Event {
    private final Server server;
    
    public DoneEvent(Customer customer, List<Server> servers, 
            Server server, double time) {
        super(customer, servers, time);
        this.server = server;
    }

    /**
     * Method to execute the DoneEvent. 
     * @return the next event to be executed 
     * in this case, return dummy FinishEvent
     */
    public Event execute() {
        Customer customer = this.getCustomer();
        List<Server> newServers = this.getServers();
        // Server server = this.getServer();
        double time = this.getTime();

        if (server.getHasWaitingCustomer()) {
            double newTime = this.getTime() + 1.0;

            Server updatedServer = new Server(server.getServerId(), 
                    true, false, newTime);

            newServers.set(server.getServerId() - 1, updatedServer);

            return new FinishEvent(customer, newServers, server, time);

        } else {
            Server updatedServer = new Server(server.getServerId(),
                    true, false, time);

            newServers.set(server.getServerId() - 1, updatedServer);
            return new FinishEvent(customer, newServers, server, time);
        }
    }

    
    /**
     * Method to get DoneEvent string when it is instantiated.  
     * @return string of the DoneEvent
     */
    public String toString() {
        return String.format("%.3f",this.getTime()) +
            ' ' + this.getCustomerId() + " done serving by " +
            this.server.getServerId();
    }
}

