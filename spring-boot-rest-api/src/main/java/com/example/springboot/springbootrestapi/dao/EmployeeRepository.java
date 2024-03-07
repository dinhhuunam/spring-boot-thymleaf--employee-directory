package com.example.springboot.springbootrestapi.dao;

import com.example.springboot.springbootrestapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Employee-entity type
//Integer-primary key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it ... no need to write any code LOL!
}
