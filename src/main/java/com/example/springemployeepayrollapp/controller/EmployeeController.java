package com.example.springemployeepayrollapp.controller;

import com.example.springemployeepayrollapp.entity.Employee;
import com.example.springemployeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/employee")
    public Employee createUSer(@RequestBody Employee employee)
    {
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/employee")
    public List<Employee> createUSer()
    {
        return employeeService.getAllEmployees();
    }
}