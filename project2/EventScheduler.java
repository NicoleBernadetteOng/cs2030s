package cs2030.simulator;

import java.util.PriorityQueue;
import java.util.function.Supplier;

/**
 * Manages all the severs and assigns customers to their respective servers.
 */
public class EventScheduler {
    private final int numArrival;
    private final PriorityQueue<Event> events;
    private Shop shop;

    /** 
     * EventScheduler to create the array of servers and add events.
     * @param seed base seed for the RandomGenerator
     * @param numServers number of servers based on the int
     * @param numCounters the number of selfCheckout counters
     * @param maxQ maximum queue length
     * @param numArrival number of arrival events to simulate
     * @param arrRate double arrival rate
     * @param servRate double service rate 
     * @param restRate double rest rate of the server from rng
     * @param probRest probability that the server will rest
     * @param probGreedy probability that the customer will be greedy 
     */
    public EventScheduler(int seed, int numServers, int numCounters, int maxQ, int numArrival, 
            double arrRate, double servRate, double restRate, double probRest, double probGreedy) {
        this.numArrival = numArrival;
        RandomGenerator rng = new RandomGenerator(seed, arrRate, servRate, restRate);

        // suppliers for rest and rest period 
        Supplier<Double> supplyRest = () -> rng.genRandomRest();
        Supplier<Double> supplyRestPeriod = () -> rng.genRestPeriod();

        this.shop = new Shop(numServers, numCounters, maxQ, probRest, supplyRest, supplyRestPeriod);
        this.events = new PriorityQueue<>(numArrival, new EventComparator());
        double now = 0;

        for (int i = 1; i <= numArrival; i++) {
            events.add(new ArriveEvent(
                        new Customer(i, now, () -> rng.genServiceTime(), 
                            rng.genCustomerType() < probGreedy)));
            now += rng.genInterArrivalTime();
        }
    }

    /**
     * Start the simulation and output the events in order.
     * Execute all the events then order it according to the comparator
     */
    public void simulate() {
        // Variables to update statistics
        double waitingTime = 0;
        int numLeft = 0;

        while (!events.isEmpty()) {
            Event thisEvent = events.poll();
            Pair<Shop, Event> next = thisEvent.execute(shop);
            shop = next.first();
            Event nextEvent = next.second();

            if (!((thisEvent instanceof ServeEvent && nextEvent instanceof ServeEvent) 
                        || thisEvent instanceof ServerRestEvent || 
                        thisEvent instanceof ServerBackEvent)) {
                System.out.println(thisEvent);
            }

            if (nextEvent != null) {
                events.add(nextEvent);
            }

            if (nextEvent instanceof LeaveEvent) {
                numLeft++;

            } else if (nextEvent instanceof WaitEvent) {
                waitingTime += nextEvent.execute(shop).second().getTime() - nextEvent.getTime();

            } else if (nextEvent instanceof ServeEvent && thisEvent instanceof ServeEvent) {
                waitingTime += nextEvent.getTime() - thisEvent.getTime();

            }
        } 

        // finally, print the statistics 
        int numServed = numArrival - numLeft;
        System.out.println("[" + 
                String.format("%.3f", numServed != 0 ? waitingTime / numServed : 0) 
                + " " + numServed + " " + numLeft + "]");
    }

}

