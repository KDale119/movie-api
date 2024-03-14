package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.Repository.DirectorRepository;
import edu.mccneb.codeschool.crudapi.model.Actor;
import edu.mccneb.codeschool.crudapi.model.ActorAdd;
import edu.mccneb.codeschool.crudapi.model.Director;
import edu.mccneb.codeschool.crudapi.model.DirectorAdd;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public ResponseEntity<List<Director>> getAllDirectors() {
        return ResponseEntity.ok(directorRepository.findAll());
    }

    public ResponseEntity<Director> findDirectorById(Integer id) {
        Optional<Director> optionalDirector =  directorRepository.findById(id);
        if (optionalDirector.isPresent()) {
            return ResponseEntity.ok(optionalDirector.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Director> deleteDirector(Integer id) {
        Director director = directorRepository.findById(id).get();
        if (director != null) {
            directorRepository.delete(director);
            return new ResponseEntity<>(null, HttpStatus. NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<DirectorAdd> addDirector(DirectorAdd add) {
        Director director = new Director();
        director.setId(director.getId());
        director.setDateOfBirth(add.getDateOfBirth());
        director.setFirstName(add.getFirstName());
        director.setLastName(add.getLastName());
        director = directorRepository.save(director);
        return ResponseEntity.ok(add);
    }

    public ResponseEntity<Director> updateDirector(Integer id, Director update) {
        Director updatedDirector =  directorRepository.findById(id).get();
        updatedDirector.setDateOfBirth(update.getDateOfBirth());
        updatedDirector.setFirstName(update.getFirstName());
        updatedDirector.setLastName(update.getLastName());
        updatedDirector = directorRepository.save(updatedDirector);
        return ResponseEntity.ok(updatedDirector);
    }
}
