package edu.mccneb.codeschool.crudapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mccneb.codeschool.crudapi.model.Actor;
import edu.mccneb.codeschool.crudapi.model.Movie;
import edu.mccneb.codeschool.crudapi.service.ActorService;
import edu.mccneb.codeschool.crudapi.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@ExtendWith(MockitoExtension.class)
@DisplayName("Movie Controller Test")
public class MovieControllerTest {
    @InjectMocks
    private MovieController subject;
    @Mock
    private MovieService productService;
    private MockMvc mockMvc;
    private HttpHeaders httpHeaders;
    private ObjectMapper mapper;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ReflectionTestUtils.setField(this, "httpHeaders", httpHeaders);
        ReflectionTestUtils.setField(this, "mapper", new ObjectMapper());
    }
    @Test
    @DisplayName("Get All Movies")
    void test_getAllMovies() throws Exception{
        MockHttpServletResponse response = mockMvc
                .perform(get("/api/movies")
                        .headers(httpHeaders))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Get Movies by Id")
    void test_getMoviesById() throws Exception{
        MockHttpServletResponse response = mockMvc
                .perform(get("/api/movies/{id}", 1)
                        .headers(httpHeaders))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Delete Movies by Id")
    void test_deleteMoviesById() throws Exception{
        MockHttpServletResponse response = mockMvc
                .perform(delete("/api/movies/{id}", 1)
                        .headers(httpHeaders))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Create Movies")
    void test_createMovies() throws Exception{
        Movie movie = new Movie();
        MockHttpServletResponse response = mockMvc
                .perform(post("/api/movies/")
                        .headers(httpHeaders)
                        .content(mapper.writeValueAsString(movie)))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Update Movies")
    void test_updateMovies() throws Exception{
        Movie updateMovie = new Movie();
        MockHttpServletResponse response = mockMvc
                .perform(put("/api/movies/{id}", 1)
                        .headers(httpHeaders)
                        .content(mapper.writeValueAsString(updateMovie)))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
