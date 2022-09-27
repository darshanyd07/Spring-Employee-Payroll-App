package com.example.demo_emp.service;

import com.example.demo_emp.dto.EmployeeDTO;
import com.example.demo_emp.entity.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Interface containing methods from service class - IEmployeeService
 */
public interface IEmployeeService
{
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getById(int id);

    String deleteById(int id);

    String editEmployee(EmployeeDTO employeeDtO, int id);
}