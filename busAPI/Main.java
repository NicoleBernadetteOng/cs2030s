import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.ArrayList;

/**
 * This program finds different ways one can travel by bus (with a bit 
 * of walking) from one bus stop to another.
 *
 * @author: Ooi Wei Tsang
 * @version: CS2030 AY19/20 Semester 1, Lab 10
 */
public class Main {
  /**
   * The program read a sequence of (id, search string) from standard input.
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    Instant start = Instant.now();
      Scanner scanner = new Scanner(System.in);

      List<CompletableFuture<String>> routes = new ArrayList<>();

      while (scanner.hasNext()) {
          BusStop srcId = new BusStop(scanner.next());
          String searchString = scanner.next();
          routes.add(BusSg.findBusServicesBetween(srcId, searchString)
                  .thenCompose(x -> x.description()));
      }
      scanner.close();

      CompletableFuture.allOf(routes.toArray(new CompletableFuture<?>[0]));

      routes.stream()
          .map(x-> x.join())
          .forEach(System.out::println);

      Instant stop = Instant.now();
      System.out.printf("Took %,dms\n", Duration.between(start, stop).toMillis());
  }
}
