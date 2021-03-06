package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Property;

import java.util.List;

public interface PropertyService {
    Property createProperty(Property property);
    Property readProperty(Long propertyId);
    Property updateProperty(Property property);
    void deleteProperty(Long property);
    List<Property> findAll();
    Property findById(Long id);

}
