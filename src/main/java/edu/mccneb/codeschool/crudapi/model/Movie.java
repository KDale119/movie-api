package edu.mccneb.codeschool.crudapi.model;

import jakarta.persistence.*;

@Entity(name = "Movies")
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "movielength")
    private Integer movieLength;
    @Column(name = "moviename")
    private String movieTitle;
    @Column(name = "releasedate")
    private String releaseDate;
    @Column(name = "trailerurl")
    private String trailerUrl;
    @Transient
    private String overview;
    @ManyToOne
    @JoinColumn(name = "directorid")
    private Director director;
    @ManyToOne
    @JoinColumn(name = "genreid")
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "ratingid")
    private Rating rating;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(Integer movieLength) {
        this.movieLength = movieLength;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
