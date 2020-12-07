package cs2030.simulator;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Manages all the severs and assigns customers to their respective servers.
 */
public class EventScheduler {
    private final int numServers;
    private final ArrayList<Double> timeArray;
    
    /** 
     * EventScheduler to create the array of servers and add events.
     * @param numServers number of servers based on the int
     * @param timeArray array of the times (double)
     */
    public EventScheduler(int numServers, ArrayList<Double> timeArray) {
        this.numServers = numServers;
        this.timeArray = timeArray;
    }

    /**
     * Start the simulation and output the events in order.
     * Execute all the events then order it according to the comparator
     */
    public void simulate() {
        // will be adding events to this events priority queue
        PriorityQueue<Event> events = new PriorityQueue<>(new EventComparator());
        List<Server> servers = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        // Variables to update statistics
        double waitingTime = 0;
        int numLeft = 0;
        int numServed = 0;

        // array of servers based on the int from the Scanner
        for (int i = 1; i <= numServers; i++) {
            servers.add(new Server(i, true, false, 0.0));
        }

        for (int i = 1; i <= timeArray.size(); i++) {
            customers.add(new Customer(i, timeArray.get(i - 1)));
        }

        for (Customer cus : customers) {
            events.add(new ArriveEvent(cus, servers));
        }

        // System.out.println("events:");
        // System.out.println(events);

        // Add each event into events 
        // poll - execute that event - add that event back into the queue
        // still execute done but dont add back in 
        // poll each event based on the comparator 

        while (events.size() > 0) {
            Event firstEvent = events.poll();
            System.out.println(firstEvent);

            // e1 is next event
            Event e1 = firstEvent.execute(); 
            // System.out.println(e1);

            // if the first event is an ArriveEvent 
            if (firstEvent instanceof ArriveEvent) {
                // serversList = e1.getServers();
                events.add(e1);

                // if the next event is a WaitEvent 
            } else if (firstEvent instanceof WaitEvent) { 
                waitingTime = waitingTime + e1.getTime() - e1.getCustomer().getTime();
                events.add(e1);

                // if ServeEvent, update the statistics
            } else if (firstEvent instanceof ServeEvent) {
                // numServed++;
                // waitingTime = waitingTime + e1.getTime() - e1.getCustomer().getTime();
                events.add(e1);
                
                // if DoneEvent, no need to add to events
            } else if (firstEvent instanceof DoneEvent) {
                numServed++;

                // if LeaveEvent. no need to add to events
            } else if (firstEvent instanceof LeaveEvent) {
                // increase the numLeft
                numLeft++;

            }
        } 
       
        // finally, print the statistics 
        double averageWaitingTime = waitingTime / numServed;
        System.out.println('[' + String.format("%.3f", averageWaitingTime) + 
                ' ' + numServed + ' ' + numLeft + ']');
    }

}

