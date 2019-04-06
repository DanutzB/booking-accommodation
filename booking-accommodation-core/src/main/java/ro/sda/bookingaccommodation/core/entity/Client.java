package ro.sda.bookingaccommodation.core.entity;

import ro.sda.bookingaccommodation.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients", schema = "booking-accommodation")
public class Client extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "telephone", length = 40, nullable = false)
    private String telephone;
}
