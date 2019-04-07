package ro.sda.bookingaccommodation.core.entity;

import ro.sda.bookingaccommodation.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments", schema = "booking-accommodation")
public class Payment extends BaseEntity {

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date", length = 8, nullable = false)
    private Date paymentDate;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
