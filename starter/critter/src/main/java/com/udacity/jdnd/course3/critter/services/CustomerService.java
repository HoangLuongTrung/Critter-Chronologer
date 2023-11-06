package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dtos.CustomerDTO;
import com.udacity.jdnd.course3.critter.entities.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(CustomerDTO customerDTO);

    List<Customer> getListCustomer();

    Customer getCustomerById(Long id);

    Customer getCustomerByPetId(Long petId);

}
