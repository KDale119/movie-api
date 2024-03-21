package edu.mccneb.codeschool.crudapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mccneb.codeschool.crudapi.model.Actor;
import edu.mccneb.codeschool.crudapi.model.Director;
import edu.mccneb.codeschool.crudapi.service.ActorService;
import edu.mccneb.codeschool.crudapi.service.DirectorService;
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
@DisplayName("Director Controller Test")
public class DirectorControllerTest {
    @InjectMocks
    private DirectorController subject;
    @Mock
    private DirectorService productService;
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
    @DisplayName("Get All Directors")
    void test_getAllDirectors() throws Exception{
        MockHttpServletResponse response = mockMvc
                .perform(get("/api/directors")
                        .headers(httpHeaders))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Get Directors by Id")
    void test_getDirectorsById() throws Exception{
        MockHttpServletResponse response = mockMvc
                .perform(get("/api/directors/{id}", 1)
                        .headers(httpHeaders))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Delete Directors by Id")
    void test_deleteDirectorsById() throws Exception{
        MockHttpServletResponse response = mockMvc
                .perform(delete("/api/directors/{id}", 1)
                        .headers(httpHeaders))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Create Directors")
    void test_createDirectors() throws Exception{
        Director newDirector = new Director();
        MockHttpServletResponse response = mockMvc
                .perform(post("/api/directors/")
                        .headers(httpHeaders)
                        .content(mapper.writeValueAsString(newDirector)))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    @DisplayName("Update Directors")
    void test_updateDirectors() throws Exception{
        Director update = new Director();

        MockHttpServletResponse response = mockMvc
                .perform(put("/api/directors/{id}", 1)
                        .headers(httpHeaders)
                        .content(mapper.writeValueAsString(update)))
                .andReturn()
                .getResponse();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
