public class RecycledLoader extends Loader {
    public RecycledLoader(int num, Cruise cruise) {
        super(num, cruise);
    }

    @Override 
    public boolean canServe(Cruise cr) {
        if (getCruise()  == null) {
            return true;
        } else {
            Cruise cru = getCruise();
            return cru.getServiceCompletionTime() + 60 <= cr.getArrivalTime();
        }
    }

    public RecycledLoader serve(Cruise cr) {
        if (canServe(cr)) {
            return new RecycledLoader(getIdentifier(), cr);
        } 
        return null;
    }

    @Override 
    public String toString() {
        return "Recycled Loader " + getIdentifier() + " serving " + getCruise();
    }
}
