class Booking {
    private final Driver driver;
    private final Request request;
    
    public Booking(Driver driver, Request request) {
        this.driver = driver;
        this.request = request;
    }


    // compare services 
    public Service compare(Request request) {
        Service takeACab = new TakeACab();
        Service justRide = new JustRide();
        Service shareARide = new ShareARide();

        if (this.driver instanceof PrivateCar) {

            if (shareARide.computeFare(request) > justRide.computeFare(request)) {
                return justRide;
            } else if (shareARide.computeFare(request) == takeACab.computeFare(request)) {
                return justRide;
            } else {
                return shareARide;
            }

        } else {

            if (takeACab.computeFare(request) > justRide.computeFare(request)) {
                return justRide;
            } else if (takeACab.computeFare(request) == takeACab.computeFare(request)) {
                return takeACab;
            } else {
                // justRide fare > takeACab fare
                return takeACab;
            }
        }
    }

    
    public int compareTo(Booking booking) {
        // fare of this 
        int thisFare = compare(this.request).computeFare(this.request);
        Integer thisFareObj = new Integer(thisFare);

        // fare of booking
        int bookingFare = compare(booking.request).computeFare(booking.request);
        Integer bookingFareObj = new Integer(bookingFare);

        int compareValue = thisFareObj.compareTo(bookingFareObj);
        
        // additional check if compareValue == 0
        if (compareValue == 0) {
            if (this.driver.getWaitingTime() > booking.driver.getWaitingTime()) {
                return 1;
            } else if (this.driver.getWaitingTime() < booking.driver.getWaitingTime()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return compareValue;
        }
    }
     
    public int getFare() {
        return compare(this.request).computeFare(this.request);
    }

    @Override 
    public String toString() {
        String fare = String.valueOf(compare(this.request).computeFare(this.request));
        int len = fare.length(); 
        fare = fare.substring(0, len-2) + "." + fare.substring(len-2);
        String serv = compare(this.request).toString();

        char c = fare.charAt(0);
        if (c == '.') {
            fare = "0" + fare;
        }

        return "$" + fare + " using " + this.driver.toString() + " (" + serv + ")"; 
    }

}
