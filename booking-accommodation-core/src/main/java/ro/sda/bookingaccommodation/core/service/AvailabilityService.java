package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Availability;

public interface AvailabilityService {

    Availability createAvailability(Availability availability);

    Availability readAvailability(Long availabilityId);

    Availability updateAvailability(Availability availability);

    void deleteAvailability(Long availabilityId);
}
