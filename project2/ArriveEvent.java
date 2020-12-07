package cs2030.simulator;

/**
 * ArriveEvent class when the customer arrives. 
 * Extends event to apply polymorphism.
 */
public class ArriveEvent extends Event {

    /**
     * Constructor for ArriveEvent. 
     * @param customer the customer that arrived
     */
    public ArriveEvent(Customer customer) {
        super(customer, customer.getTime(), shop -> {

            // if the customer is greedy
            if (customer.getIsGreedy()) {
                return Pair.of(shop, shop.earliestCounter().map(
                    shop2 -> (Event) new ServeEvent(customer, customer.getTime(), shop2))
                        .orElseGet(() -> shop.earliestAcceptableCounter()
                            .map(shop2 -> (Event) new WaitEvent(
                                customer, customer.getTime(), shop2))
                                    .orElseGet(() -> 
                                        new LeaveEvent(customer, customer.getTime()))));
            }

            // if customer is not greedy 
            return Pair.of(shop,
                shop.find(shop2 -> shop2.isAvailable()).map(
                    shop2 -> (Event) new ServeEvent(customer, customer.getTime(), shop2))
                        .orElseGet(() -> shop.find(shop2 -> shop2.canTakeServeEvent())
                                .map(shop2 -> (Event) new WaitEvent(customer, 
                                customer.getTime(), shop2))
                                .orElseGet(() -> new LeaveEvent(customer, customer.getTime()))));
        });
    }

    @Override
    public String toString() {
        return String.format("%.3f", customer.getTime()) 
            + " " + customer.print() + " arrives";
    }
}

