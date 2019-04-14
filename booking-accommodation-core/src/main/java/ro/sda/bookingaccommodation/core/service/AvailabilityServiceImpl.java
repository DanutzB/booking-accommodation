package ro.sda.bookingaccommodation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Availability;
import ro.sda.bookingaccommodation.core.repository.AvailabilityRepository;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    AvailabilityRepository availabilityRepository;

    @Override
    public Availability createAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public Availability readAvailability(Long availabilityId) {
        return availabilityRepository.findById(availabilityId);
    }

    @Override
    public Availability updateAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public void deleteAvailability(Long availabilityId) {
        availabilityRepository.delete(availabilityId);
    }

    @Override
    public List<Availability> findAll() {
        return availabilityRepository.findAll();
    }

    @Override
    public Availability findById(Long id) {
        return availabilityRepository.findById(id);
    }
}
