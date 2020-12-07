package cs2030.simulator;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {
    /**
     * Compares 2 Events and decides which is smaller, equal or greater.
     * The first key is to check for the earliest time.
     * If there is a tie breaker, customerID is checked instead.
     * @param e1 first event
     * @param e2 second event
     * @return -1 if e1 is prioritised over e2, 1 if e2 is prioritised
     */
    public int compare(Event e1, Event e2) {
        if (e1.getTime() > e2.getTime()) {
            return 1;
        } else if (e1.getTime() == e2.getTime()) {
            return e1.getCustomerId() - e2.getCustomerId();
        } else {
            return -1;
        }
    }
}

