package cs2030.simulator;

/**
 * Abstract counter class. Counter can be either a human server.
 * or a self-checkout. This class allows the creation of 
 * these different types of events.
 */
public abstract class Counter {
    protected final int id; 
    protected final boolean isAvailable; 
    protected final int numInQ; 
    protected final int maxQ; 
    protected final double nextAvailableTime;

    /**
     * Constructor for Counter.
     * @param id the counter's id 
     * @param isAvailable the availability 
     * @param numInQ is the number of customers in the q waiting to be served
     * @param maxQ is the maximum queue length
     * @param nextAvailableTime is the server's next available time 
     */
    public Counter(int id, boolean isAvailable, int numInQ, int maxQ, 
            double nextAvailableTime) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.numInQ = numInQ;
        this.maxQ = maxQ;
        this.nextAvailableTime = nextAvailableTime;
    }

    /**
     * Checks if there is a waiting customer.
     * @return boolean value representing the existence of a waiting customer 
     */
    protected boolean hasWaitingCustomer() {
        return numInQ > 0;
    }

    /**
     * Checks if the counter is available.
     * @return isAvailable 
     */
    protected boolean isAvailable() {
        return isAvailable;
    }
    
    /**
     * Returns the next available time of the counter.
     * @return The next available time
     */
    protected double getTime() {
        return nextAvailableTime;
    }

    abstract boolean canTakeServeEvent();

    abstract boolean isHuman();

    abstract boolean shouldRest();

    abstract int getNumInQ();

    abstract Counter serve(double time);

    abstract Counter makeWait();

    abstract Counter done();

    abstract String print();

    abstract String waitingNow();

    /**
     * Checks if two counters are equal.
     * @return a boolean value representing the equivalence of the counters
     */
    protected boolean equals(Counter server) {
        return id == server.id;
    }

    @Override
    public String toString() {
        if (isAvailable) {
            return this.id + " is available";
        } else if (hasWaitingCustomer()) {
            return this.id + " is busy; waiting customer to be served at " 
                    + String.format("%.3f", nextAvailableTime);
        } else {
            return this.id + " is busy; available at " + String.format("%.3f", nextAvailableTime);
        }
    }
}
