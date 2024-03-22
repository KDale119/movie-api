package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.model.Actor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Actor Service Test")
public class ActorServiceTest {
    @InjectMocks
    private ActorService subject;


    @Test
    @DisplayName("Create Actor")
    void test_createActor(){
        Actor actor = new Actor();
        subject.addActor(actor);

        assertThat(actor.getId()).isNotNull();
    }

}
