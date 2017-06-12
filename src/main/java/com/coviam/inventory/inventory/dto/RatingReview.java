package com.coviam.inventory.inventory.dto;

/**
 * Created by gaurav on 12/06/17.
 */
public class RatingReview {
    private Integer rating;
    private String review;

    public RatingReview() {
    }

    public RatingReview(int rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "RatingReview{" +
                "rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
