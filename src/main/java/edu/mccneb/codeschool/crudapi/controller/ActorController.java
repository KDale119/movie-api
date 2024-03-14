package edu.mccneb.codeschool.crudapi.controller;

import edu.mccneb.codeschool.crudapi.model.Actor;
import edu.mccneb.codeschool.crudapi.model.ActorAdd;
import edu.mccneb.codeschool.crudapi.service.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors(){
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findActorById(@PathVariable Integer id) {
        return actorService.findActorById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Actor> deleteActor(@PathVariable Integer id) {
        return actorService.deleteActor(id);
    }

    @PostMapping
    public ResponseEntity<ActorAdd> createActor(@RequestBody ActorAdd add) {
        return actorService.addActor(add);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable Integer id, @RequestBody Actor update) {
        return actorService.updateActor(id, update);
    }
}
