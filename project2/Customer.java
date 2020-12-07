package cs2030.simulator;

import java.util.function.Supplier;

public class Customer {
    private final int id;
    private final double arrivalTime;
    private final Supplier<Double> supplyServiceTime;
    private double serviceTime = 1;
    private boolean isServed = false;
    private boolean isGreedy;

    /**
     * Constructor for Customer for level 2.
     * @param id the id of the customer 
     * @param arrivalTime the time that the customer arrived 
     */
    public Customer(int id, double arrivalTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.supplyServiceTime = () -> 1.0;
    } 

    /** 
     * Constructor for Customer.
     * @param id the id of the customer 
     * @param arrivalTime the time that the customer arrived 
     * @param supplyServiceTime a supplier function to get service time
     */
    public Customer(int id, double arrivalTime, Supplier<Double> supplyServiceTime,
            boolean isGreedy) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.supplyServiceTime = supplyServiceTime;
        this.isGreedy = isGreedy;
    }

    /**
     * Gets customer id.
     * @return returns id of the customer 
     */
    public int getCustomerId() {
        return this.id;
    }

    /**
     * Gets arrival time.
     * @return returns arrival time of the customer 
     */
    public double getTime() {
        return this.arrivalTime;
    }

    /**
     * Gets the greediness of the customer.
     * @return returns the greediness of the customer 
     */
    public boolean getIsGreedy() {
        return this.isGreedy;
    }

    /**
     * Gets the service time required to serve the customer.
     * If the customer is not served, updates isServed 
     * and gets the service time from the supplier 
     * @return the service time
     */
    protected double getServiceTime() {
        if (!isServed) {
            this.isServed = true;
            this.serviceTime = supplyServiceTime.get();
        }
        return serviceTime;
    }

    /**
     * Changes the customer id to reflect greediness.
     * If customer is greedy, "(greedy)" will be added to the id.
     * @return The greediness of the customer and the customer's id
     */
    public String print() {
        return isGreedy ? id + "(greedy)" : String.valueOf(id);
    }

    @Override 
    public String toString() {
        return this.id + " arrives at " + this.arrivalTime;
    }
}
