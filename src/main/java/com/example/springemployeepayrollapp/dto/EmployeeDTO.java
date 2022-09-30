package com.example.springemployeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

//Lombok Library
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class EmployeeDTO
{
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee firstName is Invalid")
    public String firstName;
    public String lastName;

    public String profilePic;
    @NotEmpty(message = "Address Can Not Null")
    public String address;
    @Min(value = 5000 , message = "Salary Cannot Be Less Than 5000")
    @Max(value = 50000 , message = "Salary Cannot Be Greater Than 50000")
    public int salary;
    public String mobileNumber;
    public LocalDate startDate;
    public String notes;
}