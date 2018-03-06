package com.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.dao.UserRepository;
import com.demo.entities.User;


@SpringBootApplication
public class DemoSpringBanqueApplication implements CommandLineRunner{
	@Autowired
	private UserRepository userRep;


	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBanqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		User user1 = userRep.save(new User("julien", "basson", "juju@lolo.fr", "admin", "", "lolo"));
		
		// TODO Auto-generated method stub
		
	}
}
