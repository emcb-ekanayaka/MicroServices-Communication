package com.demomicroservice.employeeservice.service;

import com.demomicroservice.employeeservice.dto.EmployeeDto;
import com.demomicroservice.employeeservice.dto.Response.ApiResponseDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long id);
}
