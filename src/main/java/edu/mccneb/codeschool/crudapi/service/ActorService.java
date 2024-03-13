package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.Repository.ActorRepository;
import edu.mccneb.codeschool.crudapi.model.Actor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ResponseEntity<Actor> findActorById(Integer actorId) {
        Optional<Actor> optionalActor =  actorRepository.findById(actorId);
        if (optionalActor.isPresent()) {
            return ResponseEntity.ok(optionalActor.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
