package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    Rating readRating(Long ratingId);
    Rating updateRating(Rating rating);
    void deleteRating(Long id);
    List<Rating> findAll();
    Rating findById(Long id);
}
