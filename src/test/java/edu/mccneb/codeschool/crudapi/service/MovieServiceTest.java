package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.Repository.MovieRepository;
import edu.mccneb.codeschool.crudapi.client.MovieClient;
import edu.mccneb.codeschool.crudapi.mapper.MovieMapper;
import edu.mccneb.codeschool.crudapi.model.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Movie Service Test")
public class MovieServiceTest {
    @InjectMocks
    private MovieService subject;

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private MovieClient movieClient;

    @Mock
    private MovieMapper movieMapper;

    @Test
    @DisplayName("Create Movie")
    void test_createMovie() {
        Movie response = new Movie();
        response.setId(1);
        when(movieRepository.save(any())).thenReturn(response);
        Movie movie = new Movie();
        ResponseEntity<Movie> resp = subject.addMovie(movie);

        assertThat(resp.getBody().getId()).isNotNull();
    }
    @Test
    @DisplayName("Get All Movies")
    void test_getAllMovies(){
        Movie movie = new Movie();
        subject.addMovie(movie);
        ResponseEntity<List<Movie>> response = subject.getAllMovies();
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }
    @Test
    @DisplayName("Get Movie")
    void test_getMovie(){
        Movie movie = new Movie();
        movie.setId(1);
        when(movieRepository.findById(any())).thenReturn(Optional.of(movie));

        ResponseEntity<Movie> response = subject.findMovieById(movie.getId());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }
    @Test
    @DisplayName("Get Movie - Not Found")
    void test_getMovie_NotFound(){

        ResponseEntity<Movie> response = subject.findMovieById(1);
        assertThat(response.getStatusCode().value()).isEqualTo(404);
        assertThat(response.getBody()).isNull();
    }
    @Test
    @DisplayName("Delete Movie")
    void test_deleteMovie(){
        Movie movie = new Movie();

        when(movieRepository.findById(any())).thenReturn(Optional.of(movie));
        ResponseEntity<Movie> delete = subject.deleteMovie(movie.getId());

        assertThat(delete.getStatusCode().value()).isEqualTo(204);
    }




    @Test
    @DisplayName("Update Movie - Not Found")
    void test_updateMovie_NotFound(){
        Movie updated = new Movie();
        ResponseEntity<Movie> response = subject.updateMovie(123, updated);
        assertThat(response.getStatusCode().value()).isEqualTo(404);
    }
}
