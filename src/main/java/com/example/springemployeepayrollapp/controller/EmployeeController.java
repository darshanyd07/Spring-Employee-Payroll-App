package com.example.springemployeepayrollapp.controller;

import com.example.springemployeepayrollapp.entity.Employee;
import com.example.springemployeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/edit/{id}")
    public Employee edit(@RequestBody Employee user,@PathVariable Integer id)
    {
        Optional<Employee> studentOptional = employeeService.getById(id);

        return employeeService.editData(user,id);
    }
    @GetMapping("/employee/{id}")
    public Optional<Employee> createUSer(@PathVariable int id)
    {
        return employeeService.getById(id);
    }



    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        return employeeService.deleteById(id);
    }
}