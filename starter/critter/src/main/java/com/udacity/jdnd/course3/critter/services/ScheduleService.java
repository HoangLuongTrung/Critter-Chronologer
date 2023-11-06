package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dtos.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entities.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule createSchedule(ScheduleDTO scheduleDTO);
    List<Schedule> getListSchedules();

    List<Schedule> getScheduleByCustomerId(Long customerId);

    List<Schedule> getScheduleByPetId(Long petId);

    List<Schedule> getScheduleByEmployeeId(Long employeeId);
}
