import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Client;
import ro.sda.bookingaccommodation.core.service.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    @Rollback(false)
    public void testCreate(){
        Client client = new Client();
        client.setName("Constantin");
        client.setEmail("constantin@yahoo.com");
        client.setTelephone("0761233845");
        clientService.createClient(client);
        Assert.assertNotNull(client);
    }

    @Test
    @Rollback(false)
    public void testRead(){

        Client cli = clientService.readClient(1L);
        Long actual = cli.getId();
        Long expected = 1L;
        System.out.println(cli.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate() {
        Client client = new Client();
        client.setName("Vasile");
        client.setEmail("vasile@yahoo.com");
        client.setTelephone("0768989898");
        clientService.createClient(client);
        System.out.println("Update " + client + " to:");
        Client cli = new Client();
        cli.setName("Ionut");
        cli.setEmail("ionut@gmail.com");
        cli.setTelephone("0781955638");
        clientService.updateClient(client);
        Client expected = clientService.readClient(cli.getId());
        Client actual = cli;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
        clientService.deleteClient(client.getId());
    }

    @Test
    @Rollback(false)
    public void testDelete(){
        Client client = new Client();
        client.setName("Vasile");
        client.setEmail("vasile@yahoo.com");
        client.setTelephone("0768989898");
        clientService.createClient(client);
        clientService.readClient(client.getId());
        clientService.deleteClient(client.getId());
        Assert.assertNotNull(client);
    }
}
