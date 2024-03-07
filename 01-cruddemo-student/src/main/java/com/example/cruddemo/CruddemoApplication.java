package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			System.out.println("Hello World");
//			createStudent(studentDAO);
//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentByLastName(studentDAO);

//			queryForStudentByEmail(studentDAO);

//			updateStudent(studentDAO);

			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change the first name to "Scooby"
		System.out.println("Updating student... ");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);
		//display the update student
		System.out.println("Updating student: "+myStudent);
	}

	private void queryForStudentByEmail(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByEmail();
		for(Student student : theStudents){
			System.out.println(student);
		}
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Due");
		//display list of students
		for(Student student : theStudents){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findAllStudent();
		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//Create a student object
		System.out.println("Create new student object...");
		Student tempStudent = new Student("Dinh","Nam",
				"dinhhuunam.job@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//retrieve student based on the id: primary key
		Student myStudent = studentDAO.findById(3);
		System.out.println(myStudent);
	}

	public void createStudent(StudentDAO studentDAO){

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//displaying id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}
