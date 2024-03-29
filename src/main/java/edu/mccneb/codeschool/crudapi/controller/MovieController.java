package edu.mccneb.codeschool.crudapi.controller;

import edu.mccneb.codeschool.crudapi.model.*;
import edu.mccneb.codeschool.crudapi.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/movies")
@Tag(name = "Movie Controller")
public class MovieController {
        private final MovieService movieService;

        public MovieController(MovieService movieService) {
                this.movieService = movieService;
        }

        @GetMapping
        @Operation(description = "Get All Movies", summary = "Returns all movies")
        public ResponseEntity<List<Movie>> getAllMovies() {
                return movieService.getAllMovies();
        }

        @GetMapping("/{id}")
        @Operation(description = "Get Movie by ID", summary = "Returns movie based on given ID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Movie JSON Body", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
        }), responses = {
                        @ApiResponse(description = "Not Found", responseCode = "404", content = {
                                        @Content(schema = @Schema(example = " ")) }),
        })
        public ResponseEntity<Movie> findMovieById(@PathVariable Integer id) {
                return movieService.findMovieById(id);
        }

        @DeleteMapping("/{id}")
        @Operation(description = "Delete Movie by ID", summary = "Allows the user to delete a movie by ID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Movie JSON Body", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
        }), responses = {
                        @ApiResponse(description = "No Content", responseCode = "204", content = {
                                        @Content(schema = @Schema(example = " ")) }),
                        @ApiResponse(description = "Not Found", responseCode = "404", content = {
                                        @Content(schema = @Schema(example = " ")) }),
        })
        public ResponseEntity<Movie> deleteMovie(@PathVariable Integer id) {
                return movieService.deleteMovie(id);
        }

        @PostMapping("/")
        @Operation(description = "Create Movie", summary = "Allows the user to create a movie", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Movie JSON Body", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
        }))
        public ResponseEntity<Movie> createMovie(@RequestBody Movie add) {
                return movieService.addMovie(add);
        }

        @PutMapping("/{id}")
        @Operation(description = "Update Movie by ID", summary = "Allows the user to update a movie by ID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Movie JSON Body", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
        }), responses = {
                        @ApiResponse(description = "Not Found", responseCode = "404", content = {
                                        @Content(schema = @Schema(example = " ")) })
        })
        public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie update) {
                return movieService.updateMovie(id, update);
        }
}
