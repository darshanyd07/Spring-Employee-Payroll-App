package com.example.springemployeepayrollapp.entity;


import com.example.springemployeepayrollapp.dto.EmployeeDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Employee
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String firstName;
    public String lastName;
    public String profilePic;
    public String address;
    public int salary;
    public String mobileNumber;
    public LocalDate startDate;
    public String notes;

    public Employee()
    {

    }

    public Employee(int id, EmployeeDTO employeeDTO)
    {
        this.id = id;
        this.firstName = employeeDTO.firstName;
        this.lastName = employeeDTO.lastName;
        this.profilePic = employeeDTO.profilePic;
        this.address = employeeDTO.address;
        this.mobileNumber = employeeDTO.mobileNumber;
        this.notes = employeeDTO.notes;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.startDate;
    }


    public Employee(EmployeeDTO employeeDTO)
    {
        this.firstName = employeeDTO.firstName;
        this.lastName = employeeDTO.lastName;
        this.profilePic = employeeDTO.profilePic;
        this.address = employeeDTO.address;
        this.mobileNumber = employeeDTO.mobileNumber;
        this.notes = employeeDTO.notes;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.startDate;
    }
}