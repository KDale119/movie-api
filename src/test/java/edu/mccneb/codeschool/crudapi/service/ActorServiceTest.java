package edu.mccneb.codeschool.crudapi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import edu.mccneb.codeschool.crudapi.Repository.ActorRepository;
import edu.mccneb.codeschool.crudapi.model.Actor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Actor Service Test")
public class ActorServiceTest {
    @InjectMocks
    private ActorService subject;

    @Mock
    private ActorRepository actorRepository;


    @Test
    @DisplayName("Create Actor")
    void test_createActor() {
        Actor response = new Actor();
        response.setId(1);
        when(actorRepository.save(any())).thenReturn(response);
        Actor actor = new Actor();
        ResponseEntity<Actor> resp = subject.addActor(actor);

        assertThat(resp.getBody().getId()).isNotNull();
    }
    @Test
    @DisplayName("Get All Actors")
    void test_getAllActors(){
        Actor actor = new Actor();
        subject.addActor(actor);
        ResponseEntity<List<Actor>> response = subject.getAllActors();
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }
    @Test
    @DisplayName("Get Actor")
    void test_getActor(){
        Actor actor = new Actor();
        actor.setId(1);
        when(actorRepository.findById(any())).thenReturn(Optional.of(actor));

        ResponseEntity<Actor> response = subject.findActorById(actor.getId());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId().toString()).isEqualTo(actor.getId().toString());
    }
    @Test
    @DisplayName("Get Actor - Not Found")
    void test_getActor_NotFound(){

        ResponseEntity<Actor> response = subject.findActorById(1);
        assertThat(response.getStatusCode().value()).isEqualTo(404);
        assertThat(response.getBody()).isNull();
    }
    @Test
    @DisplayName("Delete Actor")
    void test_deleteActor(){
        Actor actor = new Actor();

        when(actorRepository.findById(any())).thenReturn(Optional.of(actor));
        ResponseEntity<Actor> delete = subject.deleteActor(actor.getId());

        assertThat(delete.getStatusCode().value()).isEqualTo(204);
    }
//    @Test
//    @DisplayName("Delete Actor - Not Found")
//    void test_deleteActor_NotFound(){
//        Actor actor = new Actor();
//
//        ResponseEntity<Actor> response = subject.deleteActor(actor.getId());
//        assertThat(response.getStatusCode().value()).isEqualTo(404);
//    }

//    @Test
//    @DisplayName("Update Actor")
//    void test_updateActor(){
//        Actor updated = new Actor();
//        when(actorRepository.save(any())).thenReturn(updated);
//
//        ResponseEntity<Actor> response = subject.updateActor(123, updated);
//        assertThat(response.getStatusCode().value()).isEqualTo(200);
//    }
    @Test
    @DisplayName("Update Actor - Not Found")
    void test_updateActor_NotFound(){
        Actor updated = new Actor();
        ResponseEntity<Actor> response = subject.updateActor(123, updated);
        assertThat(response.getStatusCode().value()).isEqualTo(404);
    }
}
