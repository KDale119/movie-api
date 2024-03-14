package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.Repository.ActorRepository;
import edu.mccneb.codeschool.crudapi.model.Actor;
import edu.mccneb.codeschool.crudapi.model.ActorAdd;
import jakarta.validation.Valid;
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


    public ResponseEntity<List<Actor>> getAllActors() {
        return ResponseEntity.ok(actorRepository.findAll());
    }

    public ResponseEntity<Actor> findActorById(Integer id) {
        Optional<Actor> optionalActor =  actorRepository.findById(id);
        if (optionalActor.isPresent()) {
            return ResponseEntity.ok(optionalActor.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Actor> deleteActor(Integer id) {
        Actor actor = actorRepository.findById(id).get();
        if (actor != null) {
            actorRepository.delete(actor);
            return new ResponseEntity<>(null, HttpStatus. NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ActorAdd> addActor(ActorAdd add) {
        Actor actor = new Actor();
        actor.setId(actor.getId());
        actor.setDateOfBirth(add.getDateOfBirth());
        actor.setFirstName(add.getFirstName());
        actor.setLastName(add.getLastName());
        actor = actorRepository.save(actor);
        return ResponseEntity.ok(add);
    }

    public ResponseEntity<Actor> updateActor(Integer id, Actor update) {
        Actor updatedActor =  actorRepository.findById(id).get();
        updatedActor.setDateOfBirth(update.getDateOfBirth());
        updatedActor.setFirstName(update.getFirstName());
        updatedActor.setLastName(update.getLastName());
        updatedActor = actorRepository.save(updatedActor);
        return ResponseEntity.ok(updatedActor);
    }
}
