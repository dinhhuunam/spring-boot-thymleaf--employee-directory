package com.example.springbootrestcrud.rest;

import com.example.springbootrestcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @PostConstruct to load the students data
    //is called only once when it's given bean is constructed
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Đinh","Nam"));
        theStudents.add(new Student("Đỗ","Khải"));
        theStudents.add(new Student("Phạm","Chi"));
        theStudents.add(new Student("Đinh","Ro"));
    }
    //define endpoint for "/student"-return a list of student
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }
    //define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //just index into the list...keep it simple for now

        // check the studentId again list size
        if((studentId >= theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return theStudents.get(studentId);
    }
    //Add an exception handler using @ExceptionHandler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorRespone> handleException(StudentNotFoundException exc){
//
//        //create a StudentErrorRespone
//        StudentErrorRespone error = new StudentErrorRespone();
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//        //return ReponseEntity
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    //add another exception handler... to catch any exception(catch all)
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorRespone> handleException(Exception exc){
//
//        //create a StudentErrorRespone
//        StudentErrorRespone error = new StudentErrorRespone();
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//        //return ReponseEntity
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}
