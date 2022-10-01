package com.example.springemployeepayrollapp.repository;

import com.example.springemployeepayrollapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
//    @Query(value = "select * from spring_employee_payroll_app.employee where department",nativeQuery = true)
    List<Employee> findEmployeeByDepartment(String department);
}
