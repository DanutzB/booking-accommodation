package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Booking;

public interface BookingService {

    Booking createBooking(Booking booking);

    Booking readBooking(Long bookingId);

    Booking updateBooking(Booking booking);

    void deletedeBooking(Long bookingId);
}
