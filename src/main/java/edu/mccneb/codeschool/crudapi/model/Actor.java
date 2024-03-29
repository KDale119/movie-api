package edu.mccneb.codeschool.crudapi.model;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Actors")
public class Actor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "actorid")
    private Integer id;
    @Column(name = "dateofbirth")
    private String dateOfBirth;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "actors", cascade = CascadeType.DETACH)
    private List<Movie> movies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
