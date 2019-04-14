package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment readPayment(Long paymentId);
    Payment updatePayment(Payment payment);
    void deletePayment(Long paymentId);
    List<Payment> findAll();
    Payment findById(Long id);
}
