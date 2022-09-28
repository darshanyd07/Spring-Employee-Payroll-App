package com.example.springemployeepayrollapp.service;

import com.example.springemployeepayrollapp.dto.EmployeeDTO;
import com.example.springemployeepayrollapp.entity.Employee;

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