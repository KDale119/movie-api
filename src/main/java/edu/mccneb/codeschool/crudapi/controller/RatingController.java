package edu.mccneb.codeschool.crudapi.controller;

import edu.mccneb.codeschool.crudapi.model.Rating;
import edu.mccneb.codeschool.crudapi.service.RatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/ratings")
@Tag(name = "Rating Controller")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    @Operation(description = "Get All Ratings", summary = "Returns all ratings")
    public ResponseEntity<List<Rating>> getRatings() {
        return ratingService.getRatings();
    }
}
