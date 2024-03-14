package edu.mccneb.codeschool.crudapi.Repository;

import edu.mccneb.codeschool.crudapi.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
