package com.example.springemployeepayrollapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data

public class Employee
{
    public String firstName;
    public String lastName;


    public String address;
    public Long salary;
    public String profilePic;

    public String note;

    /**
     * Employee Fields: id, firstName, lastName, salary, email, mobileNumber, startDate.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public int id;

    public Employee(String firstName, String lastName, String address, Long salary, String profilePic, String note,  int id)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary = salary;
        this.profilePic = profilePic;
        this.note = note;

    }


    public Employee(Employee employee)
    {
        this.id = employee.id;
        this.firstName = employee.firstName;
        this.lastName = employee.lastName;
        this.address = employee.address;
        this.profilePic = employee.profilePic;
        this.salary = employee.salary;
        this.note = employee.note;

    }

    public Employee()
    {

    }

    @Override
    public String toString()
    {
        return "Employee{" + "id=" + id + ", firstName='" + firstName + ", address='" + address +'\'' + ", profilePic='" + profilePic + '\'' + ", salary='" + salary + '\'' + ", note='" + note + '\'' + ", address='" + address +  '}';
    }
}