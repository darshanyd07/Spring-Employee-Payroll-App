package com.example.springemployeepayrollapp.service;

import com.example.springemployeepayrollapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    IEmployeeService iEmployeeService;

    public Employee addEmployee(Employee employee)
    {
        Employee newEmployee = new Employee(employee);
        iEmployeeService.save(employee);
        employee.toString();
        return newEmployee;
    }

    public List<Employee> getAllEmployees() {
        return iEmployeeService.findAll();
    }
}