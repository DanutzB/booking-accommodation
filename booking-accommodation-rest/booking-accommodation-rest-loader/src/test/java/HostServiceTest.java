import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Host;
import ro.sda.bookingaccommodation.core.service.HostService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class HostServiceTest {

    @Autowired
    private HostService hostService;

    @Test
    @Rollback(false)
    public void testCreate(){
        Host host = new Host();
        host.setName("Sorin");
        host.setEmail("sorin@yahoo.com");
        hostService.createHost(host);
        Assert.assertNotNull(host);
    }

    @Test
    @Rollback(false)
    public void testRead(){

        Host host = hostService.readHost(1L);
        Long actual = host.getId();
        Long expected = 1L;
        System.out.println(host.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate() {
        Host host1 = hostService.readHost(5L);
        host1.setName("Valentin");
        host1.setEmail("valentin@gmail.com");
        hostService.updateHost(host1);
        Host expected = hostService.readHost(host1.getId());
        Host actual = host1;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testDelete() {
        Host host = hostService.readHost(7L);
        hostService.deleteHost(host.getId());
        Assert.assertNotNull(host);
    }





}
