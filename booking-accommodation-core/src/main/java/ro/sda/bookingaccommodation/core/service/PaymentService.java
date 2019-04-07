package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment readPayment(Long paymentId);
    Payment updatePayment(Payment payment);
    void deletePayment(Long paymentId);
}
