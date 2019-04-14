import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Client;
import ro.sda.bookingaccommodation.core.entity.Host;
import ro.sda.bookingaccommodation.core.entity.Property;
import ro.sda.bookingaccommodation.core.entity.Rating;
import ro.sda.bookingaccommodation.core.service.ClientService;
import ro.sda.bookingaccommodation.core.service.HostService;
import ro.sda.bookingaccommodation.core.service.PropertyService;
import ro.sda.bookingaccommodation.core.service.RatingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class RatingServiceTest {

    @Autowired
    private RatingService ratingService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private HostService hostService;
    @Autowired
    private PropertyService propertyService;

    @Test
    @Rollback(false)
    public void testCreate() {
        Client client = new Client();
        client.setName("Sergiu");
        client.setEmail("sergiu@yahoo.com");
        client.setTelephone("0745000111");
        clientService.createClient(client);

        Host host = new Host();
        host.setName("Tudor Balan");
        host.setEmail("tudorbalan@gmail.com");
        hostService.createHost(host);

        Property property = new Property();
        property.setPropertyName("Vegas");
        property.setHost(host);
        property.setPropertyAddress("Strada strazilor nr numerelor");
        property.setPropertyContactNo("0232123456");
        property.setPropertyEmail("tudorbalan@gmail.com");
        propertyService.createProperty(property);
        Assert.assertNotNull(property);

        Rating rating = new Rating();
        rating.setClient(client);
        rating.setComment("excellent");
        rating.setProperty(property);
        rating.setRating(5);
        ratingService.createRating(rating);
        Assert.assertNotNull(rating);
    }

    @Test
    @Rollback(false)
    public void testRead() {
        Rating rat = ratingService.readRating(1L);
        Long actual = rat.getId();
        Long expected = 1L;
        System.out.println(rat.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate() {
        Client client = new Client();
        client.setName("Cristian");
        client.setEmail("cristian@yahoo.com");
        client.setTelephone("0730222888");
        clientService.createClient(client);

        Host host = new Host();
        host.setName("Moldoveanu");
        host.setEmail("imoldoveanu@gmail.com");
        hostService.createHost(host);

        Property property = new Property();
        property.setPropertyName("Casa Oana");
        property.setHost(host);
        property.setPropertyAddress("Strada Chiril 33");
        property.setPropertyContactNo("0777000444");
        property.setPropertyEmail("imoldoveanu@gmail.com");
        propertyService.createProperty(property);
        Assert.assertNotNull(property);

        Rating rating = ratingService.readRating(1L);
        System.out.println("Update " + rating + " to:");
        rating.setClient(client);
        rating.setComment("very good");
        rating.setProperty(property);
        rating.setRating(4);
        ratingService.updateRating(rating);
        System.out.println(rating);
    }

    @Test
    @Rollback(false)
    public void testDelete() {
        Rating rating = ratingService.readRating(1L);
        ratingService.deleteRating(rating.getId());
        Assert.assertNotNull(rating);
    }

}
