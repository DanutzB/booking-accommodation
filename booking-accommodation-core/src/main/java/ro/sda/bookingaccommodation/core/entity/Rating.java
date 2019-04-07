package ro.sda.bookingaccommodation.core.entity;

import ro.sda.bookingaccommodation.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "ratings", schema = "booking-accommodation")
public class Rating extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(name = "rating")
    private Integer rating;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rating{");
        sb.append("client=").append(client);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", property=").append(property);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return client.equals(rating1.client) &&
                comment.equals(rating1.comment) &&
                property.equals(rating1.property) &&
                rating.equals(rating1.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, comment, property, rating);
    }
}
