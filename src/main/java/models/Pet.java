package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pet implements Serializable {
    private long id;
    private String breed;
    private String name;
    private Date birth_date;
    private List<String> vaccinations;
    private Employee veterinarian;

    public Pet() {};

    public Pet(long id, String breed, String name, Date birth_date, List<String> vaccinations, Employee veterinarian) {
        this.id = id;
        this.breed = breed;
        this.name = name;
        this.birth_date = birth_date;
        this.vaccinations = vaccinations;
        this.veterinarian = veterinarian;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public List<String> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<String> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public Employee getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Employee veterinarian) {
        this.veterinarian = veterinarian;
    }
}
