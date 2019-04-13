
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.*;
import ro.sda.bookingaccommodation.core.enums.RoomType;
import ro.sda.bookingaccommodation.core.service.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private HostService hostService;

    @Test
    @Rollback(false)
    public void testCreate(){
        Client client = new Client();
        client.setName("Constantin");
        client.setEmail("constantin@yahoo.com");
        client.setTelephone("0761233845");
        clientService.createClient(client);

        Host host = new Host();
        host.setName("George Apetri");
        host.setEmail("georgeapetri@gmail.com");
        hostService.createHost(host);

        Property property = new Property();
        property.setPropertyName("Ceahlaul");
        property.setHost(host);
        property.setPropertyAddress("Strada Muntilor nr 8");
        property.setPropertyContactNo("0766555789");
        property.setPropertyEmail("georgeapetri@gmail.com");
        propertyService.createProperty(property);
        Assert.assertNotNull(property);

        Booking booking = new Booking();
        Calendar checkInCal = new GregorianCalendar(2014, 2, 11);
        Date checkIn = checkInCal.getTime();
        Calendar checkOutCal = new GregorianCalendar(2014, 2, 11);
        Date checkOut = checkOutCal.getTime();
        booking.setClient(client);
        booking.setProperty(property);
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setNoOfPersons(2);
        booking.setRoomType(RoomType.DOUBLE.toString());
        booking.setNoOfRooms(1);
        booking.setBookingDate(new Date());
        bookingService.createBooking(booking);

        Date date = new GregorianCalendar(2019, Calendar.MONTH, 7).getTime();
        Payment payment = new Payment();
        payment.setAmount(320L);
        payment.setPaymentDate(date);
        payment.setBooking(booking);
        paymentService.createPayment(payment);
        Assert.assertNotNull(payment);
    }

    


}
