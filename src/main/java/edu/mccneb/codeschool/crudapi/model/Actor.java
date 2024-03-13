package edu.mccneb.codeschool.crudapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Actors")
public class Actor {
    @Id
    @Column(name = "ID")
    private Integer actorId;
    @Column(name = "dateOfBirth")
    private String actorDOB;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getActorDOB() {
        return actorDOB;
    }

    public void setActorDOB(String actorDOB) {
        this.actorDOB = actorDOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
