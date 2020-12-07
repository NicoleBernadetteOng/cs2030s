package cs2030.simulator;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class ArriveEvent extends Event {

    public ArriveEvent(Customer customer, List<Server> servers) {
        super(customer, servers, customer.getTime());
    }

    /**
     * Method to get a free server based on availability and waiting slot.
     * @param servers the array of all servers
     * @return the free server.
     */
    public Server getFreeServer(Server[] servers) {
        boolean foundAServer = false;
        Server freeServer = null;

        // go through all servers to see if any is free, return the first one that is free
        for (int i = 0; i < servers.length; i++) {
            Server newServer = servers[i];
            if (newServer.canTakeServeEvent()) {
                int serverNumber = i + 1;
                //System.out.println("server " + serverNumber + " is free ");
                return newServer;
            } 
        }

        ArrayList<Double> serverAvailableTimes = new ArrayList<>();
        ArrayList<Integer> serverNumberAvailable = new ArrayList<>();

        for (int i = 0; i < servers.length; i++) {
            Server newServer = servers[i];
            if (newServer.canTakeWaitEvent()) {
                Double nextAvailableTime = newServer.getNextAvailableTime();
                Integer serverNumber = i + 1;
                serverNumberAvailable.add(serverNumber);
                serverAvailableTimes.add(nextAvailableTime);
                // System.out.println("server can take wait event, " + 
                // serverNumber + ": " + nextAvailableTime);
            }
        }

        if (serverAvailableTimes.size() != 0) {
            // to get the server with the shortest waiting time 
            // int serverIndex = serverAvailableTimes.indexOf
            // (Collections.min(serverAvailableTimes));

            // to get the first server with a free waiting slot 
            int serverIndex = serverNumberAvailable.indexOf(Collections.min(serverNumberAvailable));

            foundAServer = true;

            // not all servers are in serverAvailableTimes: 
            // only those that can take wait event, so must 
            // record the server number on its own as well
            freeServer = servers[serverNumberAvailable.get(serverIndex) - 1]; 
            return freeServer;
        }

        if (foundAServer == false) {
            return null;
        } else {
            return freeServer;
        }
    }

    /**
     * Method to execute the ArriveEvent. 
     * @return the next event to be executed 
     */
    public Event execute() {
        // from the getFreeServer method, get a free server
        Server[] serversList = new Server[this.getServers().size()];
        Server freeServer = getFreeServer(this.getServers().toArray(serversList));

        Customer customer = this.getCustomer();
        List<Server> newServers = this.getServers();
        // Server server = this.getServer();
        double time = this.getTime();

        if (freeServer == null) {
            return new LeaveEvent(customer, newServers, freeServer, time);
            
        } else if (freeServer.canTakeServeEvent()) {
            return new ServeEvent(customer, newServers, freeServer, time);

        } else if (freeServer.canTakeWaitEvent()) {
            return new WaitEvent(customer, newServers, freeServer, time);

        } else {
            System.out.println("Bug in ArriveEvent");
            return null;
        }
    }


    @Override
    public String toString() {
        return String.format("%.3f",this.getTime()) + ' ' +
            this.getCustomerId() + " arrives";
    }

}

