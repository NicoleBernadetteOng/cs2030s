import cs2030.simulator.EventScheduler;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        if (args.length == 5) {
            int seed = Integer.valueOf(args[0]);
            int numServers = Integer.valueOf(args[1]);
            int numArrival = Integer.valueOf(args[2]);
            double arrRate = Double.valueOf(args[3]);
            double servRate = Double.valueOf(args[4]);

            EventScheduler eventScheduler = new EventScheduler(seed, numServers, 0, 1,
                    numArrival, arrRate, servRate, 0, 0, 0);
            eventScheduler.simulate();

        } else if (args.length == 6) {
            int seed = Integer.valueOf(args[0]);
            int numServers = Integer.valueOf(args[1]);
            int maxQ = Integer.valueOf(args[2]);
            int numArrival = Integer.valueOf(args[3]);
            double arrRate = Double.valueOf(args[4]);
            double servRate = Double.valueOf(args[5]);

            EventScheduler eventScheduler = new EventScheduler(seed, numServers, 0, 
                    maxQ, numArrival, arrRate, servRate, 0, 0, 0);
            eventScheduler.simulate();

        } else if (args.length == 8) {
            int seed = Integer.valueOf(args[0]);
            int numServers = Integer.valueOf(args[1]);
            int maxQ = Integer.valueOf(args[2]);
            int numArrival = Integer.valueOf(args[3]);
            double arrRate = Double.valueOf(args[4]);
            double servRate = Double.valueOf(args[5]);
            double restRate = Double.valueOf(args[6]);
            double probRest = Double.valueOf(args[7]);

            EventScheduler eventScheduler = new EventScheduler(seed, numServers, 0,
                    maxQ, numArrival, arrRate, servRate, restRate, probRest, 0);
            eventScheduler.simulate();

        } else if (args.length == 9) {
            int seed = Integer.valueOf(args[0]);
            int numServers = Integer.valueOf(args[1]);
            int numCounters = Integer.valueOf(args[2]);
            int maxQ = Integer.valueOf(args[3]);
            int numArrival = Integer.valueOf(args[4]);
            double arrRate = Double.valueOf(args[5]);
            double servRate = Double.valueOf(args[6]);
            double restRate = Double.valueOf(args[7]);
            double probRest = Double.valueOf(args[8]);

            EventScheduler eventScheduler = new EventScheduler(seed, numServers, 
                    numCounters, maxQ, numArrival, arrRate, servRate, restRate, probRest, 0);
            eventScheduler.simulate();

        } else {
            int seed = Integer.valueOf(args[0]);
            int numServers = Integer.valueOf(args[1]);
            int numCounters = Integer.valueOf(args[2]);
            int maxQ = Integer.valueOf(args[3]);
            int numArrival = Integer.valueOf(args[4]);
            double arrRate = Double.valueOf(args[5]);
            double servRate = Double.valueOf(args[6]);
            double restRate = Double.valueOf(args[7]);
            double probRest = Double.valueOf(args[8]);
            double probGreedy = Double.valueOf(args[9]);

            EventScheduler eventScheduler = new EventScheduler(seed, numServers, 
                    numCounters, maxQ, numArrival, arrRate, servRate, 
                    restRate, probRest, probGreedy);
            eventScheduler.simulate();
        }

    }

}

