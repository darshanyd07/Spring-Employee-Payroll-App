package com.example.springemployeepayrollapp.service;

import com.example.springemployeepayrollapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    public List<Employee> getAllEmployees()
    {
        return iEmployeeService.findAll();
    }

    public Optional<Employee> getById(int id)
    {
        return iEmployeeService.findById(id);
    }

    public Employee editData(Employee employee,Integer id)
    {
        if (iEmployeeService.findById(id).isPresent())
        {
            iEmployeeService.save(employee);
            return employee;
        }
        return null;
    }




    public String deleteById(int id) {
        iEmployeeService.deleteById(id);
        return "Employee with ID: " + id + " is Deleted Successfully!!";
    }
}