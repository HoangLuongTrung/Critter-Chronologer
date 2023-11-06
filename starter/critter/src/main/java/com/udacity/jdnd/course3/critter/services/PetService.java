package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dtos.PetDTO;
import com.udacity.jdnd.course3.critter.entities.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PetService {
    Pet createPet(PetDTO petDTO);

    List<Pet> getListPets();

    List<Pet> getListPetByOwnerId(Long ownerId);

    Pet getPetById(Long petId);
}
