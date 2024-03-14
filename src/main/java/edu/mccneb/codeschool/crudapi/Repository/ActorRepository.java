package edu.mccneb.codeschool.crudapi.Repository;

import edu.mccneb.codeschool.crudapi.model.Actor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository <Actor, Integer> {

}
