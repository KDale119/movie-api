package edu.mccneb.codeschool.crudapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mccneb.codeschool.crudapi.model.Actor;
import edu.mccneb.codeschool.crudapi.service.ActorService;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import java.util.Arrays;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
@DisplayName("Actor Controller Test")
public class ActorControllerTest {
    @InjectMocks
    private ActorController subject;
    @Mock
    private ActorService productService;
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
    @DisplayName("Get All Actors")
    void test_getAllActors() throws Exception{
        MockHttpServletResponse response = mockMvc
                .perform(get("/api/actors")
                        .headers(httpHeaders))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Get Actors by Id")
    void test_getActorsById() throws Exception{
        MockHttpServletResponse response = mockMvc
                .perform(get("/api/actors/{id}", 1)
                        .headers(httpHeaders))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Delete Actors by Id")
    void test_deleteActorsById() throws Exception{
        MockHttpServletResponse response = mockMvc
                .perform(delete("/api/actors/{id}", 1)
                        .headers(httpHeaders))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Create Actor")
    void test_createActor() throws Exception{
        Actor newActor = new Actor();
        MockHttpServletResponse response = mockMvc
                .perform(post("/api/actors/")
                        .headers(httpHeaders)
                        .content(mapper.writeValueAsString(newActor)))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Update Actor")
    void test_updateActor() throws Exception{
        Actor update = new Actor();

        MockHttpServletResponse response = mockMvc
                .perform(put("/api/actors/{id}", 1)
                        .headers(httpHeaders)
                        .content(mapper.writeValueAsString(update)))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
