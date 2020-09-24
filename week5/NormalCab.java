class NormalCab extends Driver {
    private final String licensePlate;
    private final int waitingTime;

    public NormalCab(String licensePlate, int waitingTime) {
        this.licensePlate = licensePlate;
        this.waitingTime = waitingTime;
    }

    public String getLicense() {
        return this.licensePlate;
    }

    public int getWaitingTime() {
        return this.waitingTime;
    }

    @Override
    public String toString() {
        return this.licensePlate + " (" + this.waitingTime + " mins away) NormalCab";
    }

}
