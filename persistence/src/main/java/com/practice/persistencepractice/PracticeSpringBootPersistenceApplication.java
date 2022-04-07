package com.practice.persistencepractice;

import com.practice.persistencepractice.persistence.repository.login.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeSpringBootPersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringBootPersistenceApplication.class, args);
	}

}
