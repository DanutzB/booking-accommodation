package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Booking;

import java.util.List;

public interface BookingService {

    Booking createBooking(Booking booking);
    Booking readBooking(Long bookingId);
    Booking updateBooking(Booking booking);
    void deleteBooking(Long bookingId);
    List<Booking> findAll();
    Booking findById(Long id);

}
