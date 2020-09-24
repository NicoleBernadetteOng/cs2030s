public Booking findBestBooking(Request request, Driver[] drivers) {
    Booking booking = new Booking(drivers[0], request);
    int bookingFare = booking.getFare();

    for (int i = 1; i < drivers.length; i++) {
        
        Booking newBooking = new Booking(drivers[i], request);
        int newBookingFare = newBooking.getFare();

        if (newBookingFare < bookingFare) {
            booking = newBooking;
            bookingFare = newBookingFare;;
        }
    }
    return booking;
}
