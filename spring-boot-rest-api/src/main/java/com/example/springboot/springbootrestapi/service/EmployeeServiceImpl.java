package com.example.springboot.springbootrestapi.service;

import com.example.springboot.springbootrestapi.dao.EmployeeRepository;
import com.example.springboot.springbootrestapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

//    private EmployeeDAO employeeDAO;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }
//    @Override
//    public List<Employee> findAll() {
//        return employeeDAO.findAll();
//    }
//
//    @Override
//    public Employee findById(Integer theId) {
//        return employeeDAO.findById(theId);
//    }
//
//    @Transactional
//    @Override
//    public Employee save(Employee theEmployee) {
//        return employeeDAO.save(theEmployee);
//    }
//
//    @Transactional
//    @Override
//    public void deleteById(Integer theId) {
//        employeeDAO.deleteById(theId);
//    }

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer theId) {
        //there are some issues not match
        //return employeeRepository.findById(theId);

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            //We didn't find the employee
            throw new RuntimeException("Did not find employee id - "+theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(Integer theId) {
        employeeRepository.deleteById(theId);
    }
}
