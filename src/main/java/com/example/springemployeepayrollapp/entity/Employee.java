package com.example.springemployeepayrollapp.entity;


import com.example.springemployeepayrollapp.dto.EmployeeDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    public String gender;


    @ElementCollection
    @CollectionTable(name = "Employee_Department", joinColumns = @JoinColumn(name = "id"))
    public List<String> department;


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
        this.gender = employeeDTO.gender;
        this.address = employeeDTO.address;
        this.mobileNumber = employeeDTO.mobileNumber;
        this.department = employeeDTO.department;
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
        this.gender = employeeDTO.gender;
        this.mobileNumber = employeeDTO.mobileNumber;
        this.notes = employeeDTO.notes;
        this.department = employeeDTO.department;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.startDate;
    }
}