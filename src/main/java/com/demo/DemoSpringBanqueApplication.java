package com.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.dao.AdminRepository;
import com.demo.dao.ClassRepository;
import com.demo.dao.StudentRepository;
import com.demo.dao.TeacherRepository;
import com.demo.dao.UserRepository;
import com.demo.entities.Admin;
import com.demo.entities.GroupClass;
import com.demo.entities.Student;
import com.demo.entities.Teacher;
import com.demo.entities.User;


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


	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBanqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {


		Admin admin = adminRep.save(new Admin("julien", "chazz", "kk"));
		
		GroupClass class1 = classRep.save(new GroupClass("3CT"));
		GroupClass class2 = classRep.save(new GroupClass("3CI"));
		GroupClass class3 = classRep.save(new GroupClass("3CB"));

		
		Teacher teacher1 = teacherRep.save(new Teacher("Robin", "waxo", "cube4ever"));
		Teacher teacher2 = teacherRep.save(new Teacher("Jribi", "salma", "j2ee"));
		
		Student student1 = studentRep.save(new Student("loic", "camelot", "lolocamcam", class1));
		
		



		// TODO Auto-generated method stub
		
	}
}
