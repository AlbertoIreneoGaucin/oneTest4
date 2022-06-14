package com.tfs.oneTest4;

import com.tfs.oneTest4.domain.Role;
import com.tfs.oneTest4.domain.User;
import com.tfs.oneTest4.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class OneTest4Application {

	public static void main(String[] args) {
		SpringApplication.run(OneTest4Application.class, args);
	}

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

}
