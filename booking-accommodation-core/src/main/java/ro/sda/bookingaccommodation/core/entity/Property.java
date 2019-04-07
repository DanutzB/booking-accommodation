package ro.sda.bookingaccommodation.core.entity;

import ro.sda.bookingaccommodation.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "properties", schema = "booking-accommodation")
public class Property extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String propertyName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "host_id", nullable = false, updatable = false)
    private Host host;

    @Column(name = "email", length = 40, nullable = false)
    private String propertyEmail;

    @Column(name = "contact_no", length = 10, nullable = false)
    private String propertyContactNo;

    @Column(name = "address",length = 40, nullable = false)
    private String propertyAddress;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public String getPropertyEmail() {
        return propertyEmail;
    }

    public void setPropertyEmail(String propertyEmail) {
        this.propertyEmail = propertyEmail;
    }

    public String getPropertyContactNo() {
        return propertyContactNo;
    }

    public void setPropertyContactNo(String propertyContactNo) {
        this.propertyContactNo = propertyContactNo;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;
        Property property = (Property) o;
        return getPropertyName().equals(property.getPropertyName()) &&
                getHost().equals(property.getHost()) &&
                getPropertyEmail().equals(property.getPropertyEmail()) &&
                getPropertyContactNo().equals(property.getPropertyContactNo()) &&
                getPropertyAddress().equals(property.getPropertyAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPropertyName(), getHost(), getPropertyEmail(), getPropertyContactNo(), getPropertyAddress());
    }
}
