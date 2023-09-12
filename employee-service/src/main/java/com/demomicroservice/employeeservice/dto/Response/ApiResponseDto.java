package com.demomicroservice.employeeservice.dto.Response;

import com.demomicroservice.employeeservice.dto.DepartmentDto;
import com.demomicroservice.employeeservice.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}
