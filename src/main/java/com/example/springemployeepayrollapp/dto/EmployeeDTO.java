package com.example.springemployeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

//Lombok Library
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @NotBlank(message = "Address Can Not Empty")
    public String gender;

    @Min(value = 5000 , message = "Salary Cannot Be Less Than 5000")
    @Max(value = 50000 , message = "Salary Cannot Be Greater Than 50000")
    public int salary;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be a 10 digit number.")
    public String mobileNumber;

    @NotEmpty(message = "Department Not Empty Plz Enter Department....")
    @ElementCollection
    @CollectionTable(name = "Employee_Department", joinColumns = @JoinColumn(name = "id"))
    public List<String> department;

    @PastOrPresent(message = "Plz Enter Either Past Or Present Date....!!!! ")
    @JsonFormat(pattern = "dd-MMM-yyy")
    public LocalDate startDate;
    @NotEmpty(message = "Notes Can Not Empty")
    public String notes;
}