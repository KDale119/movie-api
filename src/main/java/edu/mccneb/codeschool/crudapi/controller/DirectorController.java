package edu.mccneb.codeschool.crudapi.controller;

import edu.mccneb.codeschool.crudapi.model.Actor;
import edu.mccneb.codeschool.crudapi.model.Director;
import edu.mccneb.codeschool.crudapi.service.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
@Tag(name = "Director Controller")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }
    @GetMapping
    @Operation(
            description = "Get All Directors",
            summary = "Returns all Directors"
    )
    public ResponseEntity<List<Director>> getAllDirectors(){
        return directorService.getAllDirectors();
    }
    @GetMapping("/{id}")
    @Operation(
            description = "Get Director by ID",
            summary = "Returns director based on given ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Director JSON Body",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Director.class)
                            )
                    }
            ),
            responses = {
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = {@Content(schema = @Schema(example = " "))}
                    ),
            }
    )
    public ResponseEntity<Director> findDirectorById(@PathVariable Integer id) {
        return directorService.findDirectorById(id);
    }
    @DeleteMapping("/{id}")
    @Operation(
            description = "Delete Director by ID",
            summary = "Allows the user to delete a director based on given ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Director JSON Body",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Director.class)
                            )
                    }
            ),
            responses = {
                    @ApiResponse(
                            description = "No Content",
                            responseCode = "204",
                            content = {@Content(schema = @Schema(example = " "))}
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = {@Content(schema = @Schema(example = " "))}
                    ),
            }
    )
    public ResponseEntity<Director> deleteDirector(@PathVariable Integer id) {
        return directorService.deleteDirector(id);
    }
    @PostMapping("/")
    @Operation(
            description = "Create Director",
            summary = "Allows the user to create a director",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Director JSON Body",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Director.class)
                            )
                    }
            )
    )
    public ResponseEntity<Director> createDirector(@RequestBody Director add) {
        return directorService.addDirector(add);
    }
    @PutMapping("/{id}")
    @Operation(
            description = "Update Director by ID",
            summary = "Allows the user to update a director based on given ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Director JSON Body",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Director.class)
                            )
                    }
            ),
            responses = {
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = {@Content(schema = @Schema(example = " "))}
                    )
            }
    )
    public ResponseEntity<Director> updateDirector(@PathVariable Integer id, @RequestBody Director update) {
        return directorService.updateDirector(id, update);
    }
}
