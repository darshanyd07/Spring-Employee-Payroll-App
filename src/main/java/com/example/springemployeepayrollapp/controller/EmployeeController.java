package com.example.springemployeepayrollapp.controller;

import com.example.springemployeepayrollapp.dto.EmployeeDTO;
import com.example.springemployeepayrollapp.dto.ResponseDTO;
import com.example.springemployeepayrollapp.entity.Employee;
import com.example.springemployeepayrollapp.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RequestMapping("/employee")
@RestController
public class EmployeeController
{

    @Autowired
    IEmployeeService iEmployeeService;


    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createEmployees(@RequestBody EmployeeDTO employeeDTO)
    {
        Employee employee1 = new Employee(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Created Successfully", iEmployeeService.addEmployee(employee1));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> getAllEmployees()
    {
        ResponseDTO responseDTO = new ResponseDTO("Employee List Received Successfully", iEmployeeService.getAllEmployees());
        log.info("Get All Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("get/{id}")
    public ResponseEntity<ResponseDTO> getByID(@PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Employee Received Successfully", iEmployeeService.getById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Employee Deleted Successfully", iEmployeeService.deleteById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<ResponseDTO> editEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Employee Updated Successfully", iEmployeeService.editEmployee(employeeDTO, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}