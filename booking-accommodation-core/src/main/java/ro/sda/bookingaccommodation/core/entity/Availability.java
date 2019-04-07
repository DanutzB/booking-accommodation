package ro.sda.bookingaccommodation.core.entity;

import ro.sda.bookingaccommodation.core.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "availability", schema = "booking-accommodation")
public class Availability extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(name = "room_name", length = 40, nullable = false)
    private String roomName;

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date", length = 8, nullable = false)
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date", length = 8, nullable = false)
    private Date toDate;

    @Column (name = "room_type", length = 40, nullable = false)
    private String roomType;

    @Column (name = "price_double", length = 10, nullable = false)
    private BigDecimal priceDouble;

    @Column (name = "price_single", length = 10, nullable = false)
    private BigDecimal priceSingle;
}
