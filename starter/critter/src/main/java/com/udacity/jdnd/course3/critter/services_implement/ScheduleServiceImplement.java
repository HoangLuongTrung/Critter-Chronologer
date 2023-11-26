package com.udacity.jdnd.course3.critter.services_implement;

import com.udacity.jdnd.course3.critter.dtos.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.repositories.ScheduleRepository;
import com.udacity.jdnd.course3.critter.services.PetService;
import com.udacity.jdnd.course3.critter.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImplement implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PetService petService;

    @Override
    public Schedule createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        List<Pet> listPets = petRepository.findAllById(scheduleDTO.getPetIds());
        List<Employee> listEmployees = employeeRepository.findAllById(scheduleDTO.getEmployeeIds());
        schedule.setDate(scheduleDTO.getDate());
        schedule.setActivities(scheduleDTO.getActivities());
        schedule.setPets(listPets);
        schedule.setEmployees(listEmployees);
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getListSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getScheduleByCustomerId(Long customerId) {
        List<Schedule> listSchedules = new ArrayList<>();
        List<Pet> listPets = petRepository.findPetByOwnerId(customerId);
        for (Pet pet: listPets) {
            listSchedules.addAll(scheduleRepository.findScheduleByPets(pet));
        }
        return listSchedules;
    }

    @Override
    public List<Schedule> getScheduleByPetId(Long petId) {
        Pet pet = petRepository.getOne(petId);
        return scheduleRepository.findScheduleByPets(pet);
    }

    @Override
    public List<Schedule> getScheduleByEmployeeId(Long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        return scheduleRepository.findScheduleByEmployees(employee);
    }
}
