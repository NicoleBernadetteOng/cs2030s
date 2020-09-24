class TakeACab extends Service {
    public int computeFare(Request request) {
        int distFare = request.getDistance() * 33;
        distFare = distFare + 200;
        return distFare;
    }

    @Override
    public String toString() {
        return "TakeACab";
    }

}
