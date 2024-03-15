package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.Repository.MovieRepository;
import edu.mccneb.codeschool.crudapi.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieRepository.findAll());
    }

    public ResponseEntity<Movie> findMovieById(Integer id) {
        Optional<Movie> optionalMovie =  movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            return ResponseEntity.ok(optionalMovie.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Movie> deleteMovie(Integer id) {
        Movie movie = movieRepository.findById(id).get();
        if (movie != null) {
            movieRepository.delete(movie);
            return new ResponseEntity<>(null, HttpStatus. NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<MovieAdd> addMovie(MovieAdd add) {
        Movie movie = new Movie();
        movie.setId(movie.getId());
        movie.setMovieLength(add.getMovieLength());
        movie.setMovieTitle(add.getMovieTitle());
        movie.setReleaseDate(add.getReleaseDate());
        movie.setTrailerUrl(add.getTrailerUrl());
        movie.setDirector(add.getDirector());
        movie.setGenre(add.getGenre());
        movie.setRating(add.getRating());
        movie = movieRepository.save(movie);
        return ResponseEntity.ok(add);
    }
    public ResponseEntity<Movie> updateMovie(Integer id, Movie update) {
        Movie updatedMovie =  movieRepository.findById(id).get();
        updatedMovie.setMovieLength(update.getMovieLength());
        updatedMovie.setMovieTitle(update.getMovieTitle());
        updatedMovie.setReleaseDate(update.getReleaseDate());
        updatedMovie.setTrailerUrl(update.getTrailerUrl());
        updatedMovie.setDirector(update.getDirector());
        updatedMovie.setGenre(update.getGenre());
        updatedMovie.setRating(update.getRating());
        updatedMovie = movieRepository.save(updatedMovie);
        return ResponseEntity.ok(updatedMovie);
    }
}
