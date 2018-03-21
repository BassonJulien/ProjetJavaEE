package com.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.dao.*;
import com.demo.entities.*;


public class DatabaseController {
	
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
	
	@RequestMapping("/createDB")
	public String createDatabase()
	{
		GroupClass class1 = classRep.save(new GroupClass("3CT"));
		GroupClass class2 = classRep.save(new GroupClass("3CI"));
		GroupClass class3 = classRep.save(new GroupClass("3CB"));
		
		
		
		Teacher teacher1 = teacherRep.save(new Teacher("Robin", "waxo", "1234"));
		Teacher teacher2 = teacherRep.save(new Teacher("Jribi", "salma", "1234"));
		Teacher teacher3 = teacherRep.save(new Teacher("Arcelier", "Fabien", "1234"));
		Teacher teacher4 = teacherRep.save(new Teacher("Herry", "Sebastien", "1234"));
		
		
		Student student1 = studentRep.save(new Student("lolo", "camelot", "1234", class1));
		Student student2 = studentRep.save(new Student("juju", "chazz", "1234", class1));
		Student student3 = studentRep.save(new Student("tom", "toto", "1234", class2));
		Student student4 = studentRep.save(new Student("jade", "jadou", "1234", class2));
		Student student5 = studentRep.save(new Student("gary", "gaga", "1234", class3));
		
		Course course1 = courseRep.save(new Course("J2EE", teacher2, class1));
		Course course2 = courseRep.save(new Course("database", teacher3, class2));
		
		News news1 = newsRep.save(new News("Froideur", "Attention au froid, couvrez vous pour ne pas attraper froid", "https://www.chosesasavoir.com/wp-content/uploads/2017/01/polesud.jpg", "20/03/18",true));
		News news2 = newsRep.save(new News("Crypto", "G20 actualité, tenez vous au courant", "https://www.coinstaker.com/wp-content/uploads/2017/11/bitcoin-digital-currency.jpg", "20/03/18",true));
		
		Mark mark = markRep.save(new Mark(student1, course1, 5));

		

		return "redirect:/home";

	}
}
