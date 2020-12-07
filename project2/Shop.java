package cs2030.simulator;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Shop {
    private final List<Counter> servers;

    /**
     * Creates Shop.
     * @param num number of counters in the shop
     */
    public Shop(int num) {
        this.servers = Stream.iterate(1, x -> x + 1)
            .limit(num).map(x -> new Server(x))
            .collect(Collectors.toList());
    }

    /**
     * Creates Shop.
     * @param numOfServers number of servers
     * @param numOfSelfCheckout number of counters (SelfCheckout)
     * @param maxQ maximum queue length
     * @param probRest probability that the server will rest
     * @param supplyRest supplies whether server rests
     * @param supplyRestPeriod supplier to provide rest period 
     */
    public Shop(int numOfServers, int numOfSelfCheckout, int maxQ, double probRest,
            Supplier<Double> supplyRest, Supplier<Double> supplyRestPeriod) {
        this.servers = Stream.iterate(1, x -> x + 1).limit(numOfServers)
            .map(x -> 
                new Server(x, maxQ, probRest, supplyRest, supplyRestPeriod))
            .collect(Collectors.toList());

        this.servers.addAll(Stream.iterate(numOfServers + 1, x -> x + 1)
            .limit(numOfSelfCheckout).map(x -> new SelfCheckout(x, maxQ, numOfServers + 1))
            .collect(Collectors.toList()));
    }


    public Shop(List<Counter> servers) {
        this.servers = servers;
    }

    /**
     * Gets a counter that satisfies a condition (predicate).
     * If there are multiple that satisfy the condiition, return the first one
     * @param func function that takes in a Counter and returns a Boolean
     * @return Optional of a Counter that satisfies the condition
     */
    protected Optional<Counter> find(Function<Counter, Boolean> func) {
        return servers.stream()
            .filter(x -> func.apply(x).equals(true))
            .findFirst();
    }

    /**
     * Replace a counter in the shop with a new counter.
     * @param counter Counter to replace with
     * @return new shop with the counter replaced
     */
    protected Shop replace(Counter counter) {
        return new Shop(servers.stream()
            .map(x -> x.id == counter.id ? counter : x)
            .collect(Collectors.toList()));
    }

    /**
     * Gets the earliest available counter.
     * @return Optional of the earliest available counter
     */
    protected Optional<Counter> earliestCounter() {
        return servers.stream().filter(x -> x.isAvailable())
            .min(Comparator.comparing(Counter::getNumInQ));
    }

    /**
     * Gets the fastest available SelfCheckout counter.
     * @return fastest available SelfCheckout counter
     */
    protected SelfCheckout fastestSelfCheckout() {
        return servers.stream().filter(x -> !x.isHuman())
            .map(x -> (SelfCheckout) x)
            .min(Comparator.comparing(Counter::getTime))
            .get();
    }

    /**
     * Finds the earliest counter that can accept waiting customers.
     * @return Optional of the earliest counter that can accept waiting customers
     */
    protected Optional<Counter> earliestAcceptableCounter() {
        return servers.stream().filter(x -> x.canTakeServeEvent())
            .min(Comparator.comparing(Counter::getNumInQ));
    }
 
    @Override 
    public String toString() {
        return this.servers.toString();
    }

}
