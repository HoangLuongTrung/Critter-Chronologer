package com.udacity.jdnd.course3.critter.services_implement;

import com.udacity.jdnd.course3.critter.dtos.PetDTO;
import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetServiceImplement implements PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Pet createPet(PetDTO petDTO) {
        Pet pet = new Pet();
        Customer customer = customerRepository.getOne(petDTO.getOwnerId());
        pet.setName(petDTO.getName());
        pet.setBirthDate(petDTO.getBirthDate());
        pet.setPetType(petDTO.getType());
        pet.setNotes(petDTO.getNotes());
        pet.setCustomer(customer);
//        Create Pet
        pet = petRepository.save(pet);
//        Add Pet to customer
        customer.getPets().add(pet);
        customerRepository.save(customer);
        return pet;
    }

    @Override
    public List<Pet> getListPets() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> getListPetByOwnerId(Long ownerId) {
        return petRepository.findPetByOwnerId(ownerId);
    }

    @Override
    public Pet getPetById(Long petId) {
        return petRepository.getOne(petId);
    }

}
