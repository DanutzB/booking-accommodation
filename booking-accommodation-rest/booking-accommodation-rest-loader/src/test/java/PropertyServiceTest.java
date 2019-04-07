import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Host;
import ro.sda.bookingaccommodation.core.entity.Property;
import ro.sda.bookingaccommodation.core.service.HostService;
import ro.sda.bookingaccommodation.core.service.PropertyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class PropertyServiceTest {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private HostService hostService;

    @Test
    @Rollback(false)
    public void testCreate(){
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
    }

    @Test
    @Rollback(false)
    public void testRead(){
        Property property = propertyService.readProperty(1L);
        Long actual = property.getId();
        Long expected = 1L;
        System.out.println(property.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate(){
        Property prop = propertyService.readProperty(1L);
        System.out.println("Update:" + prop);
        prop.setPropertyName("Raraul");
        prop.setPropertyAddress("Strada Ursilor nr 16");
        propertyService.updateProperty(prop);
        System.out.println(prop);
    }

    @Test
    @Rollback(false)
    public void testDelete(){
        Host host = new Host();
        host.setName("Daniel Babii");
        host.setEmail("danielBabii@yahoo.com");
        hostService.createHost(host);

        Property property = new Property();
        property.setPropertyName("Alpin");
        property.setPropertyAddress("Strada Vulturilor nr8");
        property.setPropertyEmail("danielbabii@yahoo.com");
        property.setPropertyContactNo("0730373554");
        property.setHost(host);
        propertyService.createProperty(property);
        propertyService.readProperty(property.getId());
        propertyService.deleteProperty(property.getId());
        Assert.assertNotNull(property);
    }



}
