package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Rating;

public interface RatingService {
    Rating createRating(Rating rating);
    Rating readRating(Long ratingId);
    Rating updateRating(Rating rating);
    void deleteRating(Rating rating);
}
