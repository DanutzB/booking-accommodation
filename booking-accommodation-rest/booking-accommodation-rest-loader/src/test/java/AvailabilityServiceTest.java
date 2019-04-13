import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Availability;
import ro.sda.bookingaccommodation.core.entity.Host;
import ro.sda.bookingaccommodation.core.entity.Property;
import ro.sda.bookingaccommodation.core.enums.RoomType;
import ro.sda.bookingaccommodation.core.service.AvailabilityService;
import ro.sda.bookingaccommodation.core.service.HostService;
import ro.sda.bookingaccommodation.core.service.PropertyService;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class AvailabilityServiceTest {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private HostService hostService;

    @Autowired
    private PropertyService propertyService;

    @Test
    @Rollback(false)
    public void testCreate(){
        Availability availability = new Availability();
        availability.setFromDate(new GregorianCalendar(2019, 6, 4).getTime());
        availability.setToDate(new GregorianCalendar(2019, 8, 4).getTime());
        availability.setPriceDouble(new BigDecimal(300));
        availability.setPriceSingle(new BigDecimal(150));
        availability.setRoomName("111");
        availability.setRoomType(RoomType.DOUBLE);
        Host host = new Host();
        host.setName("Maria");
        host.setEmail("totMaria@gmail.com");
        hostService.createHost(host);
        Property property = new Property();
        property.setPropertyName("PensiuneaMaria");
        property.setPropertyEmail("maria@gmail.com");
        property.setPropertyContactNo("0789898989");
        property.setPropertyAddress("Calarasi");
        property.setHost(host);
        propertyService.createProperty(property);
        availabilityService.createAvailability(availability);
        Assert.assertNotNull(availability);
    }

    @Test
    @Rollback(false)
    public void testRead(){
        Availability availability = availabilityService.readAvailability(1L);
        Long actual = availability.getId();
        Long expected = 1L;
        Assert.assertEquals(actual, expected);
    }

    @Test
    @Rollback(false)
    public void testUpdate(){
        Availability availability = availabilityService.readAvailability(1L);
        System.out.println("Update " + availability + " to:");
        availability.setRoomName("222");
        availability.setPriceDouble(new BigDecimal(350));
        availabilityService.updateAvailability(availability);
        System.out.println(availability);
    }

    @Test
    @Rollback(false)
    public void testDelete(){
        Availability availability = availabilityService.readAvailability(1L);
        availabilityService.deleteAvailability(1L);
        Assert.assertNotNull(availability);
    }
}
