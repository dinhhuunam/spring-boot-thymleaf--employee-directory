package com.example.springboot.springbootrestapi.service;

import com.example.springboot.springbootrestapi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(Integer theId);
    Employee save(Employee theEmployee);
    void deleteById(Integer theId);
}
