package com.tfs.oneTest4;

import com.tfs.oneTest4.domain.*;
//import com.tfs.oneTest4.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class OneTest4Application {

	public static void main(String[] args) {
		SpringApplication.run(OneTest4Application.class, args);
	}


	/*
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));


			userService.saveUser(new User(null, "John Tr", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will S", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim C", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Arnold S", "arnold", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_USER");

		};
	}

	 */




/*
	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {

		return args -> {
			Address address = new Address("US", "Pplamo", "76179");
			Student student = new Student(
					"albet",
					"gau",
					"alber@real.com",
					Gender.MALE,
					address,
					null,
					BigDecimal.TEN,
					LocalDateTime.now()
			);
			usingMongoTemplateAndQuery(repository, mongoTemplate, "alber@real.com", student);

			/*
			Can't use this unfortunately
			repository.findStudentByEmail("alber@real.com")
					.ifPresentOrElse(s -> {
						System.out.println("student lready exists");
					}, ()-> {
						System.out.println("inserting student");
						repository.insert(student);
					});



		};

	}

 */

	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {

		return args -> {

			Role adminRole = roleRepository.findByRole("ADMIN");
			if (adminRole == null) {
				Role newAdminRole = new Role();
				newAdminRole.setRole("ADMIN");
				roleRepository.save(newAdminRole);
			}

			Role userRole = roleRepository.findByRole("USER");
			if (userRole == null) {
				Role newUserRole = new Role();
				newUserRole.setRole("USER");
				roleRepository.save(newUserRole);
			}
		};

	}


	@Bean
	CommandLineRunner runner(UserRepository userRepository, MongoTemplate mongoTemplate) {

		return args -> {
			User user = new User(
					"alber@tcu.edu",
					"al",
					"pass",
					true


			);
			usingMongoTemplateAndQuery2(userRepository, mongoTemplate, "alber@tcu.edu", user);

			/*
			Can't use this unfortunately
			repository.findStudentByEmail("alber@real.com")
					.ifPresentOrElse(s -> {
						System.out.println("student lready exists");
					}, ()-> {
						System.out.println("inserting student");
						repository.insert(student);
					});

			 */

		};

	}
	public void usingMongoTemplateAndQuery2 (UserRepository repository, MongoTemplate mongoTemplate, String
			email, User user)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<User> users = mongoTemplate.find(query, User.class);

		if (users.size() > 1) {
			throw new IllegalStateException("found many users with the same email");
		}

		if (users.isEmpty()) {
			System.out.println("inserting user" + user);
			repository.insert(user);
		} else {
			System.out.println("user already exists");
		}
	}

	public void usingMongoTemplateAndQuery (StudentRepository repository, MongoTemplate mongoTemplate, String
			email, Student student)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Student> students = mongoTemplate.find(query, Student.class);

		if (students.size() > 1) {
			throw new IllegalStateException("found many students with the same email");
		}

		if (students.isEmpty()) {
			System.out.println("inserting student" + student);
			repository.insert(student);
		} else {
			System.out.println("student already exists");
		}
	}
}
