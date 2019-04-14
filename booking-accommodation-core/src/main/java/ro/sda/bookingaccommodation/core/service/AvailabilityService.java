package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Availability;

import java.util.List;

public interface AvailabilityService {

    Availability createAvailability(Availability availability);
    Availability readAvailability(Long availabilityId);
    Availability updateAvailability(Availability availability);
    void deleteAvailability(Long availabilityId);
    List<Availability> findAll();
    Availability findById(Long id);
}
