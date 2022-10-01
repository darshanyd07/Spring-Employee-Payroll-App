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

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping("/employee")
@RestController
public class EmployeeController
{

    @Autowired
    IEmployeeService iEmployeeService;


    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createEmployees(@Valid  @RequestBody EmployeeDTO employeeDTO)
    {
        Employee employee1 = new Employee(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Created Successfully", iEmployeeService.addEmployee(employee1));
        log.info("-----------Employee Data Add Successfully ------------");
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
        log.info("Get Employee Id : "+id+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Employee Deleted Successfully", iEmployeeService.deleteById(id));
        log.info("Get Employee Id : "+id+"  Data Delete Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<ResponseDTO> editEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Employee Updated Successfully", iEmployeeService.editEmployee(employeeDTO, id));
        log.info("Get Employee Id : "+id+"  Data Update Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/departmentName/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDeptData(@PathVariable String department)
    {
        List<Employee> empDataList = iEmployeeService.getEmployeeByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Success call for Departments!!!", empDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}