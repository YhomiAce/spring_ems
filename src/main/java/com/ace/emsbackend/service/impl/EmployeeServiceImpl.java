package com.ace.emsbackend.service.impl;

import org.springframework.stereotype.Service;

import com.ace.emsbackend.dto.EmployeeDto;
import com.ace.emsbackend.entity.Employee;
import com.ace.emsbackend.mapper.EmployeeMapper;
import com.ace.emsbackend.repository.EmployeeRepository;
import com.ace.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
       Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
       Employee savedEmployee = employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    
}
