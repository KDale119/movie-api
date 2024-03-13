package edu.mccneb.codeschool.crudapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Genres")
public class Genre {
    @Id
    @Column(name = "ID")
    private Integer genreId;
    @Column(name = "genre")
    private String genre;

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
