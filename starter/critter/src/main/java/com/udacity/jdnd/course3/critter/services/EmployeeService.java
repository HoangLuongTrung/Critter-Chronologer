package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dtos.EmployeeDTO;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Employee createEmployee(EmployeeDTO employeeDTO);

    Employee getEmployeeById(Long employeeId);

    List<Employee> getEmployeesByAvailability(Set<EmployeeSkill> skills, LocalDate date);
}
