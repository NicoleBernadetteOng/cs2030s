import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.concurrent.CompletableFuture;

/**
 * BusService encapsulate a bus service with a String id.  It supports
 * querying for the list of bus stops served by this service.
 *
 * @author: Ooi Wei Tsang
 * @version: CS2030 AY19/20 Semester 1, Lab 10
 */
class BusService {
  private final String serviceId;

  /**
   * Construct a BusService object with a given id.  An empty
   * Set of bus stops is initialized.
   * @param id The id of this bus service.
   */
  public BusService(String id) {
    this.serviceId = id;
  }

  /**
   * Get the current list of bus stops as a set.  Query the web server
   * if bus stops are not retrieved before.
   * @return A set of bus stops that this bus services serves.
   */
  public CompletableFuture<Set<BusStop>> getBusStops() {
    CompletableFuture<Set<BusStop>> stops =
        BusAPI.getBusStopsServedBy(serviceId)
        .thenApply(x -> new Scanner(x)
            .useDelimiter("\n")
            .tokens()
            .map(line -> line.split(","))
            .map(fields -> new BusStop(fields[0], fields[1]))
            .collect(Collectors.toSet()));

    return stops;
  }

  /**
   * Return a list of bus stops matching a given name.
   * @param  name Name (possibly partial) of a bus stop.
   * @return A list of bus stops matching the given name.
   */
  public CompletableFuture<Set<BusStop>> findStopsWith(String name) {
    return getBusStops()
       .thenApply( x -> x
        .stream()
        .filter(stop -> stop.matchName(name))
        .collect(Collectors.toSet()));
  }

  /**
   * Return the hash code of this bus service.
   * @return The hash code.
   */
  @Override
  public int hashCode() {
    return serviceId.hashCode();
  }

  /**
   * Return true if this bus service is equals to another bus service.
   * Two bus services are equal if they have the same id.
   * @param  busService another bus service to check for equality.
   * @return true if the bus servives are equal.
   */
  @Override
  public boolean equals(Object busService) {
    if (busService instanceof BusService) {
      return this.serviceId.equals(((BusService)busService).serviceId);
    } else {
      return false;
    }
  }

  /**
   * Convert this bus service to a string.
   * @return A string containing the id of this bus service.
   */
  @Override
  public String toString() {
    return serviceId;
  }
}
