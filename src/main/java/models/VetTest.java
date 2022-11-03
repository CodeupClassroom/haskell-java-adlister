package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VetTest {
    public static void main(String[] args) {
        Employee drDoolittle = new Employee(1, "John", "Doolittle", 'M');

        List<String> socsVacs = new ArrayList<>();
        socsVacs.add("rabies");
        socsVacs.add("parvo");
        socsVacs.add("bordatella");

        Pet soc = new Pet(1, "Shitzhu", "Soc", new Date(), socsVacs, drDoolittle);


        List<Pet> doolittlesPatients = new ArrayList<>();
        doolittlesPatients.add(soc);

        drDoolittle.setPatients(doolittlesPatients);

        System.out.println(drDoolittle.getPatients());

        System.out.println("Soc's Vaccines include:");
        for (String vaccine : soc.getVaccinations()) {
            System.out.println(vaccine);
        }

        System.out.println("Dr. Doolittle's Patients Vaccinations");
        for(Pet pet : drDoolittle.getPatients()) {
            System.out.println(pet.getName());
            for (String vaccine :  pet.getVaccinations()) {
                System.out.println(vaccine);
            }
        }

    }
}
