package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.Repository.DirectorRepository;
import edu.mccneb.codeschool.crudapi.model.Actor;
import edu.mccneb.codeschool.crudapi.model.Director;
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
@DisplayName("Director Service Test")
public class DirectorServiceTest {
    @InjectMocks
    private DirectorService subject;

    @Mock
    private DirectorRepository directorRepository;

    @Test
    @DisplayName("Create Director")
    void test_createDirector() {
        Director response = new Director();
        response.setId(1);
        when(directorRepository.save(any())).thenReturn(response);
        Director director = new Director();
        ResponseEntity<Director> resp = subject.addDirector(director);

        assertThat(resp.getBody().getId()).isNotNull();
    }
    @Test
    @DisplayName("Get All Directors")
    void test_getAllDirectors(){
        Director director = new Director();
        subject.addDirector(director);
        ResponseEntity<List<Director>> response = subject.getAllDirectors();
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }
    @Test
    @DisplayName("Get Director")
    void test_getDirector(){
        Director director = new Director();
        director.setId(1);
        when(directorRepository.findById(any())).thenReturn(Optional.of(director));

        ResponseEntity<Director> response = subject.findDirectorById(director.getId());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId().toString()).isEqualTo(director.getId().toString());
    }
    @Test
    @DisplayName("Get Director - Not Found")
    void test_getDirector_NotFound(){

        ResponseEntity<Director> response = subject.findDirectorById(1);
        assertThat(response.getStatusCode().value()).isEqualTo(404);
        assertThat(response.getBody()).isNull();
    }
    @Test
    @DisplayName("Delete Director")
    void test_deleteDirector(){
        Director director = new Director();

        when(directorRepository.findById(any())).thenReturn(Optional.of(director));
        ResponseEntity<Director> delete = subject.deleteDirector(director.getId());

        assertThat(delete.getStatusCode().value()).isEqualTo(204);
    }




    @Test
    @DisplayName("Update Director - Not Found")
    void test_updateDirector_NotFound(){
        Director updated = new Director();
        ResponseEntity<Director> response = subject.updateDirector(123, updated);
        assertThat(response.getStatusCode().value()).isEqualTo(404);
    }
}
