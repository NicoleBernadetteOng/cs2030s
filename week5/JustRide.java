class JustRide extends Service {

    public int computeFare(Request request) {
        // Fare is based on the distance @ 22 cents per km
        int distFare = request.getDistance() * 22;

        if (request.getTime() >= 600 && request.getTime() <= 900) {
            distFare = distFare + 500;  
        }   
        return distFare;
    }


    @Override
    public String toString() {
        return "JustRide";
    }

}
