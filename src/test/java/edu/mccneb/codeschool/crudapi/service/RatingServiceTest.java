package edu.mccneb.codeschool.crudapi.service;


import edu.mccneb.codeschool.crudapi.Repository.MovieRepository;
import edu.mccneb.codeschool.crudapi.Repository.RatingRepository;
import edu.mccneb.codeschool.crudapi.model.Genre;
import edu.mccneb.codeschool.crudapi.model.Rating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Rating Service Test")
public class RatingServiceTest {
    @InjectMocks
    private RatingService subject;

    @Mock
    private RatingRepository ratingRepository;

    @Test
    @DisplayName("Get All Ratings")
    void test_getAllRatings(){

        ResponseEntity<List<Rating>> response = subject.getRatings();
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }
}
