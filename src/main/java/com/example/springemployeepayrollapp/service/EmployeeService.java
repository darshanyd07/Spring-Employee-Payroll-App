package com.example.springemployeepayrollapp.service;

import com.example.springemployeepayrollapp.dto.EmployeeDTO;
import com.example.springemployeepayrollapp.entity.Employee;
import com.example.springemployeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeService implements IEmployeeService
{

    @Autowired
    EmployeeRepository employeeRepository;


    public Employee addEmployee(Employee employee)
    {
        log.info("-----------Employee Data Add Successfully ------------");
        return employeeRepository.save(employee);

    }


    public List<Employee> getAllEmployees()
    {
        log.info("-----------EmployeeS  All Data Show Successfully ------------");
        return employeeRepository.findAll();
    }


    public Optional<Employee> getById(int id)
    {
        log.info("-----------Employee Id "+id+ " Data Show Successfully ------------");
        return employeeRepository.findById(id);
    }


    public String deleteById(int id)
    {
        if (employeeRepository.findById(id).isPresent())
        {
            employeeRepository.deleteById(id);
            log.info("-----------Employee Id  "+id+ " Data Delete Successfully ------------");
            return "Employee with ID: " + id + " is Deleted Successfully!!";
        }
        else return "No employee was found with given id.";
    }


    public String editEmployee(EmployeeDTO employeeDTO, int id)
    {
        if (employeeRepository.findById(id).isPresent())
        {
            Employee employee1 = new Employee(id, employeeDTO);
            Employee alpha = employeeRepository.save(employee1);
            log.info("-----------Employee Id "+id+ " Data Update Successfully ------------");
            return "This is the result"+ alpha;
        }
        return "No Match";
    }
}