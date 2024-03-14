package com.ace.emsbackend.service;

import java.util.List;

import com.ace.emsbackend.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();
}
