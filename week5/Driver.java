abstract class Driver {
    // NormalCab drivers provide JustRide and TakeACab services
    // PrivateCar drivers provide JustRide and ShareARide 
    // If driver is NormalCab, cannot allow ShareARide service
    // If driver is PrivateCar, cannot allow TakeACab service
    abstract String getLicense();
    abstract int getWaitingTime();
}
