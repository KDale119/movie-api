package edu.mccneb.codeschool.crudapi.controller;

import edu.mccneb.codeschool.crudapi.model.Director;
import edu.mccneb.codeschool.crudapi.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }
    @GetMapping
    public ResponseEntity<List<Director>> getAllActors(){
        return directorService.getAllDirectors();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Director> findDirectorById(@PathVariable Integer id) {
        return directorService.findDirectorById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Director> deleteDirector(@PathVariable Integer id) {
        return directorService.deleteDirector(id);
    }
    @PostMapping("/")
    public ResponseEntity<Director> createDirector(@RequestBody Director add) {
        return directorService.addDirector(add);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable Integer id, @RequestBody Director update) {
        return directorService.updateDirector(id, update);
    }
}
