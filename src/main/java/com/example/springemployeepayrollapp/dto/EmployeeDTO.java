package com.example.springemployeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

//Lombok Library
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO
{
    public String firstName;
    public String lastName;

    public String profilePic;
    public String address;
    public int salary;
    public String mobileNumber;
    public LocalDate startDate;
    public String notes;
}