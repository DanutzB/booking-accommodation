package ro.sda.bookingaccommodation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Property;
import ro.sda.bookingaccommodation.core.entity.Rating;
import ro.sda.bookingaccommodation.core.repository.PropertyRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property readProperty(Long propertyId) {
        return propertyRepository.findById(propertyId);
    }

    @Override
    public Property updateProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.delete(propertyId);
    }
}
