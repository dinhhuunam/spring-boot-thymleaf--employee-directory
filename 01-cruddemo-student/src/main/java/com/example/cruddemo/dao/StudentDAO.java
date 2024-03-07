package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAllStudent();

    List<Student> findByLastName(String theLastName);

    List<Student> findByEmail();

    void update(Student theStudent);

    void delete(Integer id);
}
