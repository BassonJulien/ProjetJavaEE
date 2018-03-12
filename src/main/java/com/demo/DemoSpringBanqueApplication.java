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

	private AdminRepository adminRep;
	@Autowired
	private ClassRepository classRep;
	@Autowired
	private TeacherRepository teacherRep;
	@Autowired
	private StudentRepository studentRep;
	@Autowired
	private NewsRepository newsRep;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBanqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		//Student student1 = sutdentRep.save(new Student("lolo", "cam","0205", null));
		//Teacher teacher1 = teacherRep.save(new Teacher("juju", "juju","0205", null));
		//Admin admin1 = adminRep.save(new Admin("tom", "tom","0205"));

		Admin admin = adminRep.save(new Admin("julien", "chazz", "kk"));
		
		GroupClass class1 = classRep.save(new GroupClass("3CT"));
		GroupClass class2 = classRep.save(new GroupClass("3CI"));
		GroupClass class3 = classRep.save(new GroupClass("3CB"));

		
		Teacher teacher1 = teacherRep.save(new Teacher("Robin", "waxo", "cube4ever"));
		Teacher teacher2 = teacherRep.save(new Teacher("Jribi", "salma", "j2ee"));
		
		Student student1 = studentRep.save(new Student("loic", "camelot", "lolocamcam", class1));
		News news1 = newsRep.save(new News("ici il fait beau", "camelot", "lolocamcam", "string",true));

		



		// TODO Auto-generated method stub
		
	}
}
