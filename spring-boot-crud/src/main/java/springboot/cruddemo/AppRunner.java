package springboot.cruddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import springboot.cruddemo.dao.StudentDAO;
import springboot.cruddemo.entity.Student;

import java.util.List;

@Component
@ComponentScan("springboot.cruddemo.dao")
public class AppRunner implements CommandLineRunner {
    @Autowired
    private StudentDAO studentDAO;


    @Override
    public void run(String... args) throws Exception {
        //createStudent(studentDAO);

        //createMultipleStudents(studentDAO);

        //readStudent(studentDAO);

        //queryForStudents(studentDAO);

        //getStudentSort(studentDAO);

        //queryForStudentsByLastName(studentDAO);

        //updateStudent(studentDAO);

        //deleteStudent(studentDAO);

        deleteAllStudents(studentDAO);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");

        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: "+numRowsDeleted);

    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: "+studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        //retrieve student based on the id: primary key
        int studentId = 6;
        System.out.println("Getting student with id: "+studentId);

        Student myStudent = studentDAO.findById(6);

        //change first name to "Đỗ"
        if(myStudent!=null){
            System.out.println("Updating student...");
            myStudent.setFirstName("TRẦN");
            myStudent.setLastName("MINH AN");
            myStudent.setEmail("tranminhanh@gmail.com");
            //update the student
            studentDAO.update(myStudent);
        }
        //display the updated student
        System.out.println(myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("HỮU NAM");

        for(Student temp : theStudents){
            System.out.println(temp);
        }
    }

    private void getStudentSort(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAllAndSort();

        for(Student temp : theStudents){
            System.out.println(temp);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();

        for(Student temp : theStudents){
            System.out.println(temp);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object ... ");
        Student temp = new Student("TRẦN","TRỌNG HIẾU","trantronghieu.job@gmail.com");
        studentDAO.save(temp);

        int id = temp.getId();
        System.out.println("Saved student: "+id);

        Student myStudent = studentDAO.findById(id);
        System.out.println(myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Create 4 students objects...");
        Student temp1 = new Student("ĐINH","HỮU NAM","dinhhuunam.job@gmail.com");
        Student temp2 = new Student("ĐINH","VĂN RO","dinhvanro.job@gmail.com");
        Student temp3 = new Student("ĐỒNG","THỊ HÀ","dongthiha.job@gmail.com");
        Student temp4 = new Student("ĐINH","THỊ NHUNG","dinhthinhung.job@gmail.com");
        studentDAO.save(temp1);
        studentDAO.save(temp2);
        studentDAO.save(temp3);
        studentDAO.save(temp4);
    }

    private void createStudent(StudentDAO studentDAO) {
        Student temp = new Student("DINH","NAM","dinhhuunam.job@gmail.com");
        studentDAO.save(temp);

        System.out.println("Create Student Success: "+temp.getId());
    }
}
