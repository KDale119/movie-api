package edu.mccneb.codeschool.crudapi.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "Actors")
public class Actor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer actorId;
    @Column(name = "dateofbirth")
    private String actorDOB;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
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
