package com.udacity.jdnd.course3.critter.services_implement;

import com.udacity.jdnd.course3.critter.dtos.EmployeeDTO;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeImplement implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employeeDTO.setSkills(employeeDTO.getSkills());
        employeeDTO.setDaysAvailable(employeeDTO.getDaysAvailable());
        return employee;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.getOne(employeeId);
    }

    @Override
    public List<Employee> getEmployeesByAvailability(Set<EmployeeSkill> skills, LocalDate date) {
        return employeeRepository.findEmployeeByAvailableDays(date.getDayOfWeek()).stream().filter(employee -> employee.getSkills().containsAll(skills)).collect(Collectors.toList());
    }
}
