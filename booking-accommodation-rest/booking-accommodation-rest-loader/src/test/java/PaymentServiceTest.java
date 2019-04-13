
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Payment;
import ro.sda.bookingaccommodation.core.service.PaymentService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    @Rollback(false)
    public void testCreate(){


        Date date = new GregorianCalendar(2019, Calendar.MONTH, 7).getTime();
        Payment payment = new Payment();
        payment.setAmount(320L);
        payment.setPaymentDate(date);
        paymentService.createPayment(payment);
        Assert.assertNotNull(payment);
    }


}
