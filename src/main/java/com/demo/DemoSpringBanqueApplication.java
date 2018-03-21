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

	@Autowired
	private MarkRepository markRep;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBanqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {


		//Student student1 = sutdentRep.save(new Student("lolo", "cam","0205", null));
		//Teacher teacher1 = teacherRep.save(new Teacher("juju", "juju","0205", null));
		//Admin admin1 = adminRep.save(new Admin("tom", "tom","0205"));

		/*Admin admin = adminRep.save(new Admin("julien", "chazz", "kk"));
		
		GroupClass class1 = classRep.save(new GroupClass("3CT"));
		GroupClass class2 = classRep.save(new GroupClass("3CI"));
		GroupClass class3 = classRep.save(new GroupClass("3CB"));

		
		Teacher teacher1 = teacherRep.save(new Teacher("Robin", "waxo", "cube4ever"));
		Teacher teacher2 = teacherRep.save(new Teacher("Jribi", "salma", "j2ee"));
		
		Course course1 = courseRep.save(new Course("J2EE", teacher2, class1));
		Course course2 = courseRep.save(new Course("database", teacher2, class2));
		Course course3 = courseRep.save(new Course("clientserver", teacher1, class1));
		Course course4 = courseRep.save(new Course("database", teacher2, class1));



		
		Student student1 = studentRep.save(new Student("loic", "camelot", "lolocamcam", class1));
		News news1 = newsRep.save(new News("ici il fait beau", "camelot", "lolocamcam", "string",true));*/

	/*	GroupClass class2 = classRep.save(new GroupClass("3CI"));

		Student student2 = studentRep.save(new Student("jade", "dagher", "1234", class2));*/

		
		//SELECT course.name, group_class.name FROM intranetPortal.course inner join teacher on  course.teacher_id= teacher.id_teacher inner join group_class on course.class_id=group_class.class_id where teacher.id_teacher="2";
		/*Student student1 = studentRep.save(new Student("lolo", "cam","0205", null));
		GroupClass class1 = classRep.save(new GroupClass("3CT"));
		Teacher teacher2 =teacherRep.save( new Teacher("Jribi", "salma", "j2ee"));

		Course course4 = courseRep.save(new Course("database", teacher2, class1));
		
		Mark mark = markRep.save(new Mark(student1, course4, 5));*/

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
//	<c:when test="${slot.name.equals('10AM')}">
//	<td>${slot.getMonday()}</td>
//	<td>${slot.getTuesday()}</td>
//	<td>${slot.getWednesday()}</td>
//	<td>${slot.getThursday()}</td>
//	<td>${slot.getFriday()}</td>
//</c:when>
//<c:when test="${slot.name.equals('12AM')}">
//	<td>${slot.getMonday()}</td>
//	<td>${slot.getTuesday()}</td>
//	<td>${slot.getWednesday()}</td>
//	<td>${slot.getThursday()}</td>
//	<td>${slot.getFriday()}</td>
//</c:when>
//<c:when test="${slot.name.equals('2PM')}">
//	<td>${slot.getMonday()}</td>
//	<td>${slot.getTuesday()}</td>
//	<td>${slot.getWednesday()}</td>
//	<td>${slot.getThursday()}</td>
//	<td>${slot.getFriday()}</td>
//</c:when>
//<c:when test="${slot.name.equals('4PM')}">
//	<td>${slot.getMonday()}</td>
//	<td>${slot.getTuesday()}</td>
//	<td>${slot.getWednesday()}</td>
//	<td>${slot.getThursday()}</td>
//	<td>${slot.getFriday()}</td>
//</c:when>
//<c:when test="${slot.name.equals('6PM')}">
//	<td>${slot.getMonday()}</td>
//	<td>${slot.getTuesday()}</td>
//	<td>${slot.getWednesday()}</td>
//	<td>${slot.getThursday()}</td>
//	<td>${slot.getFriday()}</td>
//</c:when>
}
