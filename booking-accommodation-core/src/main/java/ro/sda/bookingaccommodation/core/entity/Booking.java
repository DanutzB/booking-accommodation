package ro.sda.bookingaccommodation.core.entity;

import ro.sda.bookingaccommodation.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bookings", schema = "booking_accommodation")
public class Booking extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false, updatable = false)
    private Client client;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property property;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_in", length = 8, nullable = false)
    private Date checkIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_out", length = 8, nullable = false)
    private Date checkOut;

    @Column(name = "no_of_persons", length = 3,nullable = false)
    private Integer noOfPersons;

    @Column(name = "room_type", length = 40, nullable = false)
    private String roomType;

    @Column(name = "no_of_rooms", length = 3,nullable = false)
    private Integer noOfRooms;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date", length = 8, nullable = false)
    private Date bookingDate;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getNoOfPersons() {
        return noOfPersons;
    }

    public void setNoOfPersons(Integer noOfPersons) {
        this.noOfPersons = noOfPersons;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return getClient().equals(booking.getClient()) &&
                getProperty().equals(booking.getProperty()) &&
                getCheckIn().equals(booking.getCheckIn()) &&
                getCheckOut().equals(booking.getCheckOut()) &&
                getNoOfPersons().equals(booking.getNoOfPersons()) &&
                getRoomType().equals(booking.getRoomType()) &&
                getNoOfRooms().equals(booking.getNoOfRooms()) &&
                getBookingDate().equals(booking.getBookingDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClient(), getProperty(), getCheckIn(), getCheckOut(), getNoOfPersons(), getRoomType(), getNoOfRooms(), getBookingDate());
    }
}
