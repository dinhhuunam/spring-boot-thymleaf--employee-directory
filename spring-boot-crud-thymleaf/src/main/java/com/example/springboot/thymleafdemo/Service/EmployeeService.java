package com.example.springboot.thymleafdemo.Service;

import com.example.springboot.thymleafdemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(Integer theId);
    void save(Employee theEmployee);
    void delete(Integer id);
}
