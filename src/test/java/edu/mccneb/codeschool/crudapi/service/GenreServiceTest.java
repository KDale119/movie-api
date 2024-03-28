package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.Repository.GenreRepository;
import edu.mccneb.codeschool.crudapi.model.Genre;
import edu.mccneb.codeschool.crudapi.model.Movie;
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
@DisplayName("Genre Service Test")
public class GenreServiceTest {
    @InjectMocks
    private GenreService subject;

    @Mock
    private GenreRepository genreRepository;

}
