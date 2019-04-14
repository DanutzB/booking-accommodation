package ro.sda.bookingaccommodation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Payment;
import ro.sda.bookingaccommodation.core.repository.PaymentRepository;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment readPayment(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.delete(paymentId);
    }

    @Override
    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id){
        return paymentRepository.findById(id);
    }


}
