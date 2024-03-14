package edu.mccneb.codeschool.crudapi.model;

import jakarta.persistence.*;

@Entity(name = "Ratings")
public class Rating {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer ratingId;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private String rating;

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
