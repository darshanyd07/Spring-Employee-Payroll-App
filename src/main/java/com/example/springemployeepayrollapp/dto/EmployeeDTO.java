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
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee First Name is Invalid")
    public String firstName;
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee Last Name is Invalid")
    public String lastName;
    @NotEmpty(message = "ProfilePic Can Not Empty")
    public String profilePic;
    @NotEmpty(message = "Address Can Not Empty")
    public String address;
    @Min(value = 5000 , message = "Salary Cannot Be Less Than 5000")
    @Max(value = 50000 , message = "Salary Cannot Be Greater Than 50000")
    public int salary;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be a 10 digit number.")
    public String mobileNumber;
    @NotEmpty(message = "Start Date Can Not Empty")
    public LocalDate startDate;
    @NotEmpty(message = "Notes Can Not Empty")
    public String notes;
}