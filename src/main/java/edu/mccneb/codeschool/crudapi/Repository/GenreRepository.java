package edu.mccneb.codeschool.crudapi.Repository;

import edu.mccneb.codeschool.crudapi.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
