package com.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.dao.*;
import com.demo.entities.*;



@SpringBootApplication
public class DemoSpringBanqueApplication implements CommandLineRunner{
	@Autowired
	private StudentRepository sutdentRep;
	@Autowired
	private TeacherRepository teacherRep;
	@Autowired
	private AdminRepository adminRep;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBanqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		//Student student1 = sutdentRep.save(new Student("lolo", "cam","0205", null));
		//Teacher teacher1 = teacherRep.save(new Teacher("juju", "juju","0205", null));
		//Admin admin1 = adminRep.save(new Admin("tom", "tom","0205"));

		// TODO Auto-generated method stub
		
	}
}
