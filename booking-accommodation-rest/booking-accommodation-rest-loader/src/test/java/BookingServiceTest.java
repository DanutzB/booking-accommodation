import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Booking;
import ro.sda.bookingaccommodation.core.entity.Client;
import ro.sda.bookingaccommodation.core.entity.Host;
import ro.sda.bookingaccommodation.core.entity.Property;
import ro.sda.bookingaccommodation.core.enums.RoomType;
import ro.sda.bookingaccommodation.core.service.BookingService;
import ro.sda.bookingaccommodation.core.service.ClientService;
import ro.sda.bookingaccommodation.core.service.HostService;
import ro.sda.bookingaccommodation.core.service.PropertyService;

import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private HostService hostService;

    @Autowired
    private PropertyService propertyService;

    @Test
    @Rollback(false)
    public void testCreate() {
        Booking booking = new Booking();
        booking.setBookingDate(new GregorianCalendar(2019, 5, 13).getTime());
        booking.setCheckIn(new GregorianCalendar(2019, 6, 4).getTime());
        booking.setCheckOut(new GregorianCalendar(2019,6,10).getTime());
        booking.setNoOfPersons(2);
        booking.setNoOfRooms(1);
        booking.setRoomType(RoomType.DOUBLE.toString());
        Client client = new Client();
        client.setName("Ilie");
        client.setEmail("ilie@yahoo.com");
        client.setTelephone("0781422394");
        clientService.createClient(client);

        booking.setClient(client);
        Host host = new Host();
        host.setName("Gigi");
        host.setEmail("gigi@gmail.com");
        hostService.createHost(host);

        Property property = new Property();
        property.setPropertyAddress("Chisinau");
        property.setPropertyContactNo("0731255555");
        property.setPropertyEmail("prop@yahoo.ro");
        property.setPropertyName("PensiuneaGigi");
        property.setHost(host);
        propertyService.createProperty(property);

        booking.setProperty(property);
        bookingService.createBooking(booking);
        Assert.assertNotNull(booking);
    }

    @Test
    @Rollback(false)
    public void testRead(){
        Booking booking = bookingService.readBooking(1L);
        Long actual = booking.getId();
        Long expected = 1L;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate(){
        Booking booking = bookingService.readBooking(1L);
        System.out.println("Update " + booking + " to:");
        booking.setCheckOut(new GregorianCalendar(2019, 8, 13).getTime());
        booking.setCheckIn(new GregorianCalendar(2019, 8, 13).getTime());
        bookingService.updateBooking(booking);
        System.out.println(booking);
    }

    @Test
    @Rollback(false)
    public void testDelete(){
        Booking booking = bookingService.readBooking(1L);
        bookingService.deletedeBooking(1L);
        Assert.assertNotNull(booking);
    }
}
