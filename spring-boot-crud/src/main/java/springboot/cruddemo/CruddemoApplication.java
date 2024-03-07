package springboot.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springboot.cruddemo.dao.StudentDAO;
import springboot.cruddemo.entity.Student;

@SpringBootApplication
//@ComponentScan("springboot.cruddemo.dao")
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
}
