package com.example.demo_emp.service;

import com.example.demo_emp.dto.EmployeeDTO;
import com.example.demo_emp.entity.Employee;
import com.example.demo_emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService implements IEmployeeService
{

    @Autowired
    EmployeeRepository employeeRepository;


    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }


    public Optional<Employee> getById(int id) {
        return employeeRepository.findById(id);
    }


    public String deleteById(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee with ID: " + id + " is Deleted Successfully!!";
        } else return "No employee was found with given id.";
    }


    public String editEmployee(EmployeeDTO employeeDTO, int id) {
        if (employeeRepository.findById(id).isPresent()) {
            Employee employee1 = new Employee(id, employeeDTO);
            Employee alpha = employeeRepository.save(employee1);
            return "This is the result"+ alpha;
        }
        return "No Match";
    }
}