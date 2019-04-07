package ro.sda.bookingaccommodation.core.entity;

import ro.sda.bookingaccommodation.core.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "availability", schema = "booking-accommodation")
public class Availability extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(name = "room_name", length = 40, nullable = false)
    private String roomName;

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date", nullable = false)
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date", nullable = false)
    private Date toDate;

    @Column (name = "room_type", length = 40, nullable = false)
    private String roomType;

    @Column (name = "price_double", length = 10, nullable = false)
    private BigDecimal priceDouble;

    @Column (name = "price_single", length = 10, nullable = false)
    private BigDecimal priceSingle;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getPriceDouble() {
        return priceDouble;
    }

    public void setPriceDouble(BigDecimal priceDouble) {
        this.priceDouble = priceDouble;
    }

    public BigDecimal getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(BigDecimal priceSingle) {
        this.priceSingle = priceSingle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Availability)) return false;
        Availability that = (Availability) o;
        return getProperty().equals(that.getProperty()) &&
                getRoomName().equals(that.getRoomName()) &&
                getFromDate().equals(that.getFromDate()) &&
                getToDate().equals(that.getToDate()) &&
                getRoomType().equals(that.getRoomType()) &&
                getPriceDouble().equals(that.getPriceDouble()) &&
                getPriceSingle().equals(that.getPriceSingle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProperty(), getRoomName(), getFromDate(), getToDate(), getRoomType(), getPriceDouble(), getPriceSingle());
    }
}
