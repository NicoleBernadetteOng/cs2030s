class BigCruise extends Cruise {
    private final int loaderNum = 40;
    private final int serveSpeed = 50; // 50 passengers per minute 

    public BigCruise(String identifier, int arrivalTime, int length, int passengerNo) {
        // to round up an integer division, use (num + divisor - 1) / divisor
        super(identifier, arrivalTime, (length + 40 - 1)/40, (passengerNo + 50 - 1)/50);
    } 
}
