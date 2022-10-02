package com.example.springemployeepayrollapp.service;

import com.example.springemployeepayrollapp.dto.EmployeeDTO;
import com.example.springemployeepayrollapp.entity.Employee;
import com.example.springemployeepayrollapp.exception.CustomException;
import com.example.springemployeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public Employee addEmployee(Employee employee) {
        log.info("-----------Employee Data Add Successfully ------------");
        return employeeRepository.save(employee);

    }


    public List<Employee> getAllEmployees() {
        if (employeeRepository.findAll().isEmpty()) {
            log.info("-----------No employee in database.------------");
            throw new CustomException("No employee in database.");

        } else return employeeRepository.findAll();

    }


    public Optional<Employee> getById(int id)
    {
        if (employeeRepository.findById(id).isPresent()) {
            log.info("---------Employee Id :- " + id + " Show Successfully -----------");
            return employeeRepository.findById(id);

        } else throw new CustomException("No employee matches with the given ID");
    }


    public String deleteById(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            log.info("---------Employee Id :- " + id + " Delete Successfully -----------");
            return "Employee with ID: " + id + " is Deleted Successfully!!";
        } else throw new CustomException("No employee matches with the given ID");
    }


    public String editEmployee(EmployeeDTO employeeDTO, int id) {
        if (employeeRepository.findById(id).isPresent()) {
            Employee employee1 = new Employee(id, employeeDTO);
            Employee alpha = employeeRepository.save(employee1);
            log.info("-----------Employee Id " + id + " Data Update Successfully ------------");
            return "This is the result" + alpha;
        } else throw new CustomException("No employee matches with the given ID");
    }

    public List<Employee> getEmployeeByDepartment(String department)
    {
        if (employeeRepository.findEmployeeByDepartment(department).isEmpty())
        {
            log.info("No " + department + " Department In Database....");
            throw new CustomException("No " + department + " Department In Database....");

        }
        else
        {
            log.info(department + " Department All Data Dispaly Successfully....");
            return employeeRepository.findEmployeeByDepartment(department);
        }

    }

    public List<Employee> getUsersByFirstName(String firstName)
    {
        return employeeRepository.getUsersByFirstName(firstName);
    }
}

