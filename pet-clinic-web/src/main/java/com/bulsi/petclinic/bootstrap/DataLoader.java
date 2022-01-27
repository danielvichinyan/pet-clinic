package com.bulsi.petclinic.bootstrap;

import com.bulsi.petclinic.model.Owner;
import com.bulsi.petclinic.model.Vet;
import com.bulsi.petclinic.services.OwnerService;
import com.bulsi.petclinic.services.VetService;
import com.bulsi.petclinic.services.map.OwnerServiceMap;
import com.bulsi.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner ownerOne = new Owner();
        ownerOne.setId(1L);
        ownerOne.setFirstName("Daniel");
        ownerOne.setLastName("Vichinyan");

        this.ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setId(2L);
        ownerTwo.setFirstName("Ivan");
        ownerTwo.setLastName("Ivanov");

        this.ownerService.save(ownerTwo);

        System.out.println("Loaded owners...");

        Vet vetOne = new Vet();
        vetOne.setId(1L);
        vetOne.setFirstName("Grigor");
        vetOne.setLastName("Dimitrov");

        this.vetService.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setId(2L);
        vetTwo.setFirstName("Teodora");
        vetTwo.setLastName("Todorova");

        this.vetService.save(vetTwo);

        System.out.println("Loaded vets...");
    }
}
