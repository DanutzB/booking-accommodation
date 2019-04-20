package ro.sda.bookingaccommodation.core.repository;

import javafx.beans.property.Property;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.sda.bookingaccommodation.core.base.EntityRepository;
import ro.sda.bookingaccommodation.core.entity.Availability;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface AvailabilityRepository extends EntityRepository<Availability> {

    List<Availability> findByFromDateLessThanEqualAndToDateGreaterThanEqual(Date start, Date end);


}
