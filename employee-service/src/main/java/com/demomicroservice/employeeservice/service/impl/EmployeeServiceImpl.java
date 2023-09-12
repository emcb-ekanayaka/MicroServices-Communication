package com.demomicroservice.employeeservice.service.impl;

import com.demomicroservice.employeeservice.dto.DepartmentDto;
import com.demomicroservice.employeeservice.dto.EmployeeDto;
import com.demomicroservice.employeeservice.dto.Response.ApiResponseDto;
import com.demomicroservice.employeeservice.entity.Employee;
import com.demomicroservice.employeeservice.repository.EmployeeRepository;
import com.demomicroservice.employeeservice.service.Api.ApiClient;
import com.demomicroservice.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final ApiClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RestTemplate restTemplate, WebClient webClient, ApiClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
        this.webClient = webClient;
        this.apiClient = apiClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
       Employee saveEmployee = employeeRepository.save(employee);

       EmployeeDto  saveEmployeeDto = new EmployeeDto(
               saveEmployee.getId(),
               saveEmployee.getFirstname(),
               saveEmployee.getLastname(),
               saveEmployee.getEmail(),
               saveEmployee.getDepartmentCode()
       );
        return saveEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        /**Micro-Services Communication By Rest-Template*/
        /*ResponseEntity<DepartmentDto> responseEntity = restTemplate.
                getForEntity("http://localhost:8083/api/v1/department/" + employee.getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/

        /**Micro-Services Communication By WebClient*/
        /*DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8083/api/v1/department/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

        /**Micro-Services Communication By Feign-Client*/
        DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
