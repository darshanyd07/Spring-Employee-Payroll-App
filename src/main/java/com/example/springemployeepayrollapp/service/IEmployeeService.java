package com.example.springemployeepayrollapp.service;

import com.example.springemployeepayrollapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeService extends JpaRepository<Employee, Integer>
{

}