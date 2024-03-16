package com.ace.emsbackend.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.ace.emsbackend.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto) throws SQLIntegrityConstraintViolationException;

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatEmployee);

    String deleteEmployee(Long employeeId);
}
