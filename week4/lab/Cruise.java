class Cruise {
    private final String identifier;
    private final int arrivalTime;
    private final int numOfLoader;
    private final int serviceTime;

    public Cruise(String identifier, int arrivalTime, int numOfLoader, int serviceTime) {
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
        this.numOfLoader = numOfLoader;
        this.serviceTime = serviceTime;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    // to simply get the arrival time 
    public int getArrTime() {
        return this.arrivalTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime%100 + (this.arrivalTime/100)*60;
    }

    @Override
    public String toString() {
        return this.identifier + "@" + String.format("%04d", this.arrivalTime);
    }

    // returns time the service completes in minutes since midnight 
    public int getServiceCompletionTime() {
        return this.getArrivalTime() + this.serviceTime;
    }

    public int getNumOfLoadersRequired() {
        return this.numOfLoader;
    }

}

