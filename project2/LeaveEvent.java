package cs2030.simulator;

class LeaveEvent extends Event {
    
    /** 
     * Creates a LeaveEvent.
     * @param customer customer that is involved in the event 
     * @param time time of event
     */
    public LeaveEvent(Customer customer, double time) {
        super(customer, time, shop -> Pair.of(shop, null));
    }

    @Override
    public String toString() {
        return String.format("%.3f", customer.getTime()) 
            + " " + customer.print() + " leaves";
    }
}

