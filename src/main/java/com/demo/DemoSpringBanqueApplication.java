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
	@Autowired
	private CourseRepository courseRep;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBanqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {


//		Admin admin1 = adminRep.save(new Admin("tom", "tom","0205"));
//
//		Admin admin = adminRep.save(new Admin("julien", "chazz", "1234"));
//		
//		GroupClass class1 = classRep.save(new GroupClass("3CT"));
//		GroupClass class2 = classRep.save(new GroupClass("3CI"));
//		GroupClass class3 = classRep.save(new GroupClass("3CB"));
//		
//		Teacher teacher1 = teacherRep.save(new Teacher("Robin", "waxo", "1234"));
//		Teacher teacher2 = teacherRep.save(new Teacher("Jribi", "salma", "1234"));
//		Teacher teacher3 = teacherRep.save(new Teacher("Arcelier", "Fabien", "1234"));
//		Teacher teacher4 = teacherRep.save(new Teacher("Herry", "Sebastien", "1234"));
//
//		
//		Student student1 = studentRep.save(new Student("loic", "camelot", "1234", class1));
//
//		News news1 = newsRep.save(new News("ici il fait beau", "camelot", "lolocamcam", "string",true));

//		Course course1 = courseRep.save(new Course("EMBER",teacher1,class1));
//		Course course2 = courseRep.save(new Course("J2EE",teacher2,class2));
//		Course course3 = courseRep.save(new Course("BDD",teacher3,class3));
//
//  

		// TODO Auto-generated method stub
		
	}
}
