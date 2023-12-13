package com.dee.springboot.restapi.user;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import org.slf4j.Logger;


@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private UserDetailsRepository repository;
	
	
	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public void run(String... args) throws Exception {
		repository.save(new UserDetails(1L, "Dee", "Developer"));
		repository.save(new UserDetails(2L, "Sid", "Developer"));
		repository.save(new UserDetails(3L, "Raj", "Admin"));
		
		List<UserDetails> users = repository.findByRole("Admin");
		
		users.forEach(user -> logger.info(user.toString()));
	}

	
}
