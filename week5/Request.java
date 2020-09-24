class Request {
    private final int distance;
    private final int passengers;
    private final int time;

    public Request(int distance, int passengers, int time) {
        this.distance = distance;
        this.passengers = passengers;
        this.time = time;
    }

    public int  getDistance() {
        return this.distance;
    }

    public int getPassengers() {
        return this.passengers;
    }

    public int getTime() {
        return this.time;
    }


    @Override
    public String toString() {
        return this.distance + "km for " + this.passengers + "pax @ " + this.time + "hrs";
    }
}
