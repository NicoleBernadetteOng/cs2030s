import cs2030.simulator.EventScheduler;

import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numServers = scanner.nextInt();
        ArrayList<Double> timeArray = new ArrayList<>();

        while (scanner.hasNextDouble()) {
            double arrivalTime = scanner.nextDouble();
            timeArray.add(arrivalTime);
        }

        scanner.close();

        EventScheduler eventScheduler = new EventScheduler(numServers, timeArray);
        eventScheduler.simulate();
    }

}

