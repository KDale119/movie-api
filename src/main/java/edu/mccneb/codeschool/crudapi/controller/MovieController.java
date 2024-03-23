package edu.mccneb.codeschool.crudapi.controller;

import edu.mccneb.codeschool.crudapi.model.*;
import edu.mccneb.codeschool.crudapi.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Tag(name = "Movie Controller")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable Integer id) {
        return movieService.findMovieById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Integer id) {
        return movieService.deleteMovie(id);
    }
    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie add) {
        return movieService.addMovie(add);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie update) {
        return movieService.updateMovie(id, update);
    }
}
