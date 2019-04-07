package ro.sda.bookingaccommodation.core.entity;

import ro.sda.bookingaccommodation.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings", schema = "booking_accommodation")
public class Booking extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_in", length = 8, nullable = false)
    private Date checkIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_out", length = 8, nullable = false)
    private Date checkOut;

    @Column(name = "no_of_persons", length = 2,nullable = false)
    private Integer noOfPersons;

    @Column(name = "room_type", length = 40, nullable = false)
    private String roomType;

    @Column(name = "no_of_rooms", length = 3,nullable = false)
    private Integer noOfRooms;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date", length = 8, nullable = false)
    private Date bookingDate;

}
