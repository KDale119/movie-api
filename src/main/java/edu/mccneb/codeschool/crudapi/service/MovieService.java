package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.Repository.MovieRepository;
import edu.mccneb.codeschool.crudapi.client.MovieClient;
import edu.mccneb.codeschool.crudapi.mapper.MovieMapper;
import edu.mccneb.codeschool.crudapi.model.*;
import edu.mccneb.codeschool.crudapi.utils.SSLUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieClient movieClient;
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    public MovieService(MovieClient movieClient, MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieClient = movieClient;
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieRepository.findAll());
    }

    public ResponseEntity<Movie> findMovieById(Integer id) {
        Optional<Movie> optionalMovie =  movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            try {
                SSLUtils.turnOffSslChecking();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (KeyManagementException e) {
                throw new RuntimeException(e);
            }
            Results results = movieClient.getOverview(movie.getMovieTitle());
            Movie mappedMovie = movieMapper.mapMovie(results, movie);
            return ResponseEntity.ok(mappedMovie);
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
    public ResponseEntity<Movie> addMovie(Movie add) {
        add = movieRepository.save(add);
        return ResponseEntity.ok(add);
    }
    public ResponseEntity<Movie> updateMovie(Integer id, Movie update) {
        Optional<Movie> updatedMovie =  movieRepository.findById(id);
        if (updatedMovie.isPresent()) {
            update = movieRepository.save(update);
            return ResponseEntity.ok(updatedMovie.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
