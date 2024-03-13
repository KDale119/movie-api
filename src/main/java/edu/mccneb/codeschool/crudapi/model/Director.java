package edu.mccneb.codeschool.crudapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Directors")
public class Director {
    @Id
    @Column(name = "ID")
    private Integer directorId;
    @Column(name = "dateOfBirth")
    private String directorDOB;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getDirectorDOB() {
        return directorDOB;
    }

    public void setDirectorDOB(String directorDOB) {
        this.directorDOB = directorDOB;
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
