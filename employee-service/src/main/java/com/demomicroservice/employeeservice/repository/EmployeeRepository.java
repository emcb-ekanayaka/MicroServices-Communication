package com.demomicroservice.employeeservice.repository;

import com.demomicroservice.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
