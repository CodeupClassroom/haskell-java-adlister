package models;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private char gender;
    private List<Pet> patients;

    public Employee(){};

    public Employee(long id, String firstName, String lastName, char gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Employee(long id, String firstName, String lastName, char gender, List<Pet> patients){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.patients = patients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public List<Pet> getPatients() {
        return patients;
    }

    public void setPatients(List<Pet> patients) {
        this.patients = patients;
    }
}
