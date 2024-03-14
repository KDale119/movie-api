package edu.mccneb.codeschool.crudapi.Repository;

import edu.mccneb.codeschool.crudapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
