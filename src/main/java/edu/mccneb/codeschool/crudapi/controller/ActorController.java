package edu.mccneb.codeschool.crudapi.controller;

import edu.mccneb.codeschool.crudapi.model.Actor;
import edu.mccneb.codeschool.crudapi.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/actors")
@Tag(name = "Actor Controller")
public class ActorController {
        private final ActorService actorService;

        public ActorController(ActorService actorService) {
                this.actorService = actorService;
        }

        @GetMapping
        @Operation(description = "Get All Actors", summary = "Returns all actors")
        public ResponseEntity<List<Actor>> getAllActors() {
                return actorService.getAllActors();
        }

        @GetMapping("/{id}")
        @Operation(description = "Get Actor by ID", summary = "Returns actor based on given ID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Actor JSON Body", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Actor.class))
        }), responses = {
                        @ApiResponse(description = "Not Found", responseCode = "404", content = {
                                        @Content(schema = @Schema(example = " ")) }),
        })
        public ResponseEntity<Actor> findActorById(@PathVariable Integer id) {
                return actorService.findActorById(id);
        }

        @DeleteMapping("/{id}")
        @Operation(description = "Delete Actor by ID", summary = "Allows the user to delete an actor based on given ID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Actor JSON Body", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Actor.class))
        }), responses = {
                        @ApiResponse(description = "No Content", responseCode = "204", content = {
                                        @Content(schema = @Schema(example = " ")) }),
                        @ApiResponse(description = "Not Found", responseCode = "404", content = {
                                        @Content(schema = @Schema(example = " ")) }),
        })
        public ResponseEntity<Actor> deleteActor(@PathVariable Integer id) {
                return actorService.deleteActor(id);
        }

        @PostMapping("/")
        @Operation(description = "Create Actor", summary = "Allows the user to create an actor", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Actor JSON Body", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Actor.class))
        }))
        public ResponseEntity<Actor> createActor(@RequestBody Actor add) {
                return actorService.addActor(add);
        }

        @PutMapping("/{id}")
        @Operation(description = "Update Actor by ID", summary = "Allows the user to update an actor based on given ID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Actor JSON Body", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Actor.class))
        }), responses = {
                        @ApiResponse(description = "Not Found", responseCode = "404", content = {
                                        @Content(schema = @Schema(example = " ")) })
        })
        public ResponseEntity<Actor> updateActor(@PathVariable Integer id, @RequestBody Actor update) {
                return actorService.updateActor(id, update);
        }
}
