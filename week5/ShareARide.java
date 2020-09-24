class ShareARide extends Service {
    public int computeFare(Request request) {
        int distFare = request.getDistance() * 50;
        
        if (request.getTime() >= 600 && request.getTime() <= 900) {
            distFare = distFare + 500;
        }
        int indFare = distFare/request.getPassengers();
        return indFare;
    }

    @Override 
    public String toString() {
        return "ShareARide";
    }
}
