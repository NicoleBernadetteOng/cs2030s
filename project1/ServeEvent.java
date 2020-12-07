package cs2030.simulator;

import java.util.List;

/**
 * ServeEvent class to simulate the start of service to a customer by a server.
 */
class ServeEvent extends Event {
    private final double SERVICE_TIME = 1.0;
    private final Server server;

    /**
     * Creates a ServeEvent.
     * @param customer customer that the event is involving
     * @param time time at which event is created
     * @param server server that the ServedEvent belongs to
     */
    public ServeEvent(Customer customer, List<Server> servers, 
            Server server, double time) {
        super(customer, servers, time);
        this.server = server;
    }
    
  
    public Event execute() {
        Customer customer = this.getCustomer();
        List<Server> newServers = this.getServers();
        // Server server = this.getServer();
        double newTime = this.getTime() + SERVICE_TIME;

        Server updatedServer = new Server(server.getServerId(),
                false, false, newTime);

        newServers.set(server.getServerId() - 1, updatedServer); 

        return new DoneEvent(customer, newServers, server, newTime);
    }

    @Override
    public String toString() {
        return String.format("%.3f",this.getTime()) + ' ' +
                this.getCustomerId() + " served by " + this.server.getServerId();
    }
}
