class Loader {
    private final int num;
    private final Cruise cruise;

    public Loader(int num, Cruise cruise) {
        this.num = num;
        this.cruise = cruise;
    }

    public Loader(int num) {
        this.num = num;
        this.cruise = null;
    }

    public int getIdentifier() {
        return this.num;
    }

    public Cruise getCruise() {
        return this.cruise;
    }   

    public int getNextAvailableTime() {
        return this.cruise.getServiceCompletionTime();
    }   


    public boolean canServe(Cruise cruise) {
        if (this.cruise == null) {
            return true;
        } else {
            return this.cruise.getServiceCompletionTime() <= cruise.getArrivalTime();
        }
    }

    public Loader serve(Cruise cruise) {
        if (canServe(cruise)) {
            return new Loader(this.num, cruise);
        } else {
            return new Loader(this.num, this.cruise);
        }
    }

    @Override
    public String toString() { 
        return "Loader " + this.num + " serving " + cruise.getIdentifier() + "@" + String.format("%04d", cruise.getArrTime());
    }

}   
