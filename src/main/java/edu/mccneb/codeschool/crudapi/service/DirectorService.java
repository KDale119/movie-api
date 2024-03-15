package edu.mccneb.codeschool.crudapi.service;

import edu.mccneb.codeschool.crudapi.Repository.DirectorRepository;
import edu.mccneb.codeschool.crudapi.model.Director;
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
        Optional<Director> director = directorRepository.findById(id);
        if (director.isPresent()) {
            directorRepository.delete(director.get());
            return new ResponseEntity<>(null, HttpStatus. NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Director> addDirector(Director add) {
        add = directorRepository.save(add);
        return ResponseEntity.ok(add);
    }

    public ResponseEntity<Director> updateDirector(Integer id, Director update) {
        Optional<Director> updatedDirector =  directorRepository.findById(id);
        if (updatedDirector.isPresent()) {
            update = directorRepository.save(update);
            return ResponseEntity.ok(updatedDirector.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
