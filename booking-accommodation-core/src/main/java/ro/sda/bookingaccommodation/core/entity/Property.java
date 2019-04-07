package ro.sda.bookingaccommodation.core.entity;

import ro.sda.bookingaccommodation.core.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table (name = "properties", schema = "booking-accommodation")
public class Property extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String propertyName;

    @OneToOne
    @JoinColumn(name = "host_id")
    private Host host;

    @Column(name = "email", length = 40, nullable = false)
    private String propertyEmail;

    @Column(name = "contact_no", length = 10, nullable = false)
    private Integer propertyContactNo;

    @Column(name = "adress",length = 40, nullable = false)
    private String propertyAdress;

}
