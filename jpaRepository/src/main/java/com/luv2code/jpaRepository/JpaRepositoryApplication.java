package com.luv2code.jpaRepository;

import com.luv2code.jpaRepository.dao.InstructorDetailRepository;
import com.luv2code.jpaRepository.dao.InstructorRepository;
import com.luv2code.jpaRepository.dao.UserRepository;
import com.luv2code.jpaRepository.entity.Instructor;
import com.luv2code.jpaRepository.entity.InstructorDetail;
import com.luv2code.jpaRepository.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRepositoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorRepository instructorRepository,
	InstructorDetailRepository instructorDetailRepository){
		return runner -> {
			//createUser(userRepository);

			//findAllUser(userRepository);

			//findUserById(userRepository);

			//updateUser(userRepository);

			//findUserByAtk(userRepository);

			//findUserByAgi(userRepository);

			//createInstructor(instructorRepository);

			//findInstructor(instructorRepository);

			//deleteInstructor(instructorRepository);

			//findInstructorDetail(instructorRepository);

			deleteInstructorDetail(instructorRepository,instructorDetailRepository);
		};
	}

	private void deleteInstructorDetail(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository) {
		int theId = 3;
		System.out.println("Deleting instructor detail id "+theId);

		instructorRepository.findInstructorDetailById(theId).getInstructor().setInstructorDetail(null);

		instructorDetailRepository.deleteById(theId);

		System.out.println("DONE!!!");
	}

	private void findInstructorDetail(InstructorRepository instructorRepository) {

		int theId = 2;
		InstructorDetail temp = instructorRepository.findInstructorDetailById(theId);

		System.out.println("Temp Instructor Detail: "+temp);

		System.out.println(temp.getInstructor());

		System.out.println("DONE!!!");
	}

	private void deleteInstructor(InstructorRepository instructorRepository) {
		int theId = 2;

		System.out.println("Deleting instructor id: "+theId);
		instructorRepository.deleteById(theId);

		System.out.println("Done!!!");
	}

	private void findInstructor(InstructorRepository instructorRepository) {
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);

		Instructor temp = instructorRepository.findInstructorById(theId);

		System.out.println("Instructor: "+temp);
		System.out.println("Instructor detail: "+temp.getInstructorDetail());
	}

	private void createInstructor(InstructorRepository instructorRepository) {
		//create Instructor
		Instructor tempInstructor =
				new Instructor("Đinh","Nam","dinhhuunam.job@gmail.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://fpt-software.udemy.com/course",
						"Java");

		//associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		System.out.println("Saving instructor: "+tempInstructor);

		instructorRepository.save(tempInstructor);
		System.out.println("Done!!!");
	}

	private void findUserByAgi(UserRepository userRepository) {
		List<User> list = userRepository.findAllUserByAgi(25,30);
		for(User user : list){
			System.out.println(user);
		}
	}
	private List<User> findUserByAtk(UserRepository userRepository) {
		int atk = 26;
		List<User> list = userRepository.findAllByAtk(atk);

		for(User user : list){
			System.out.println(user);
		}
		return list;
	}
	private User updateUser(UserRepository userRepository) {
		Long theId = 2L;
		Optional<User> result = userRepository.findById(theId);
		User user =null;
		if(result.isPresent()){
			user=result.get();
		}else{
			throw new RuntimeException("Not found id user: "+theId);
		}
		user.setAgi(30);
		userRepository.save(user);
		System.out.println(user);
		return user;
	}
	private User findUserById(UserRepository userRepository) {
		Long theId = 10L;
		Optional<User> result = userRepository.findById(theId);
		User user =null;
//		if(result.isEmpty()){
//			throw new RuntimeException("Not found id user "+theId);
//		}
//		user = result.get();
//		System.out.println(user);
		if(result.isPresent()){
			user=result.get();
		}else{
			throw new RuntimeException("Not found id user: "+theId);
		}
		return user;
	}
	private void createUser(UserRepository userRepository) {
		List<User> list = new ArrayList<>();
		list.add(new User(25,25,25,25,25));
		list.add(new User(26,26,26,26,26));
		list.add(new User(27,27,27,27,27));
		for(User user : list){
			userRepository.save(user);
		}
	}
	private void findAllUser(UserRepository userRepository) {
		List<User> users=userRepository.findAll();
		for(User user : users){
			System.out.println(user);
		}
	}
}