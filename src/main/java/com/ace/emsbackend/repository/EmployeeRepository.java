package com.ace.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ace.emsbackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
