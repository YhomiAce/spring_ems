package com.ace.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ace.emsbackend.dto.EmployeeDto;
import com.ace.emsbackend.entity.Employee;
import com.ace.emsbackend.exception.ResourceNotFoundException;
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

    private Employee findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
        return employee;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = this.findEmployeeById(id);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatEmployee) {
        Employee employee = this.findEmployeeById(employeeId);
        employee.setFirstName(updatEmployee.getFirstName());
        employee.setLastName(updatEmployee.getLastName());
        employee.setEmail(updatEmployee.getEmail());
        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public String deleteEmployee(Long employeeId) {
        this.findEmployeeById(employeeId);
        employeeRepository.deleteById(employeeId);
        return "Employee deleted successfully";
    }

}
