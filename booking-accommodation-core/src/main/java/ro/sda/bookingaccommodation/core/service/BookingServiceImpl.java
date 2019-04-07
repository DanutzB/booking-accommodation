package ro.sda.bookingaccommodation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Booking;
import ro.sda.bookingaccommodation.core.repository.BookingRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking readBooking(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deletedeBooking(Long bookingId) {
        bookingRepository.delete(bookingId);
    }
}
