package com.demomicroservice.employeeservice.service.Api;

import com.demomicroservice.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8083", value = "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping("api/v1/department/{department-code}")
    DepartmentDto getDepartment(@PathVariable(value = "department-code") String departmentCode);
}
