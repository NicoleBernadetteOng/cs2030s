package cs2030.simulator;

/**
 * SelfCheckout counters have a shared queue.
 * SelfCheckout extends the Counter class, making it a server of sorts.
 */
public class SelfCheckout extends Counter {
    protected final int firstCheckout;
    static double sharedQueue = 0;

    /**
     * Creates SelfCheckout.
     * @param id the counter's id
     * @param isAvailable counter's availability
     * @param maxQ maximum queue length
     * @param nextAvailableTime next available time of the counter
     * @param firstCheckout id of the first selfheckout counter
     */
    public SelfCheckout(int id, boolean isAvailable, int maxQ, 
            double nextAvailableTime, int firstCheckout) {
        super(id, isAvailable, (int) sharedQueue, maxQ, nextAvailableTime);
        this.firstCheckout = firstCheckout;
    }

    /**
     * Initialises SelfCheckout.
     * @param id is the server's id
     * @param maxQ is the maximum queue length
     * @param firstCheckout is the id of the first self-checkout counter
     */
    public SelfCheckout(int id, int maxQ, int firstCheckout) {
        super(id, true, 0, maxQ, 0);
        this.firstCheckout = firstCheckout;
    }

    /**
     * SelfCheckout is not human hence. 
     * @return false
     */
    protected boolean isHuman() {
        return false;
    }

    /**
     * Gets the number of customers in the queue.
     * @return number of customers in queue
     */
    protected int getNumInQ() {
        return (int) sharedQueue;
    }

    /**
     * Checks whether a counter can serve.
     * @return boolean representing if can serve
     */
    protected boolean canTakeServeEvent() {
        return maxQ - sharedQueue > 0;
    }

    /**
     * Checks whether a counter should go to rest.
     * SelfCheckout never rests hence returns false 
     * @return boolean representing if counter should rest
     */
    protected boolean shouldRest() {
        return false;
    }

    /**
     * Updates SelfCheckout to serving a customer.
     * @param time when the counter serves a customer
     * @return updated SelfCheckout
     */
    protected SelfCheckout serve(double time) {
        sharedQueue = Math.max(sharedQueue - 1, 0);
        return new SelfCheckout(id, false, maxQ, time, firstCheckout);
    }

    /**
     * Updates to add a waiting customer.
     * @return updated SelfCheckout 
     */
    protected SelfCheckout makeWait() {
        sharedQueue += 0.5;
        return new SelfCheckout(id, false, maxQ, nextAvailableTime, firstCheckout);
    }

    /**
     * Update to finish serving a customer.
     * @return updated SelfCheckout
     */
    protected SelfCheckout done() {
        return new SelfCheckout(id, true, maxQ, nextAvailableTime, firstCheckout);
    }

    /**
     * Returns the counter type and id.
     * @return counter type and id
     */
    public String print() {
        return "self-check " + id;
    }

    /**
     * Returns the counter type and id when a customer waits in the queue.
     * @return counter type and id
     */
    public String waitingNow() {
        return "self-check " + firstCheckout;
    }
}