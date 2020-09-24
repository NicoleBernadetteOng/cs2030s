class SmallCruise extends Cruise {
    private final int loaderNum = 1;
    private final int timeService = 30;

    public SmallCruise(String identifier, int arrivalTime) {
        super(identifier, arrivalTime, 1, 30);
    } 
}
