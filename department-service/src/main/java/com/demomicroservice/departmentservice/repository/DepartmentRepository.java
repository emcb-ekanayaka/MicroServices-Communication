package com.demomicroservice.departmentservice.repository;

import com.demomicroservice.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM department_db_1.department as d where d.department_code=?1")
    Department findDepartmentByCode(String code);
}
