package com.demo.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.*;

import com.demo.entities.Admin;
import com.demo.entities.Course;
import com.demo.entities.GroupClass;
import com.demo.entities.News;
import com.demo.entities.Student;
import com.demo.entities.Teacher;

@Service
@Transactional
public class IntranetMetierImplement implements IntranetMetierInterface {

	@Autowired
	private StudentRepository studentRep;
	@Autowired
	private TeacherRepository teacherRep;
	@Autowired
	private AdminRepository adminRep;
	@Autowired
	private NewsRepository newsRep;
	@Autowired
	private ClassRepository classRep;
	@Autowired
	private CourseRepository courseRep;

	@Override
	public void createAdmin(String name, String username, String password) {
		// TODO Auto-generated method stub
		Admin admin = adminRep.save(new Admin(name, username, password));

	}

	@Override
	public void createStudent(String name, String username, String password, GroupClass studentClass) {
		// TODO Auto-generated method stub
		Student student = studentRep.save(new Student(name, username, password, studentClass));

	}

	@Override
	public void createTeacher(String name, String username, String password) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherRep.save(new Teacher(name, username, password));

	}

	@Override
	public void createNews(String title, String description, String image, String date, boolean isActive) {
		// TODO Auto-generated method stub
		News news = newsRep.save(new News(title, description, image, date, isActive));

	}

	@Override
	public List<GroupClass> getGroupClassList() {
		return classRep.getGroupClassList();
	}

	@Override
	public List<News> getNewsList() {
		// TODO Auto-generated method stub
		return newsRep.getNewsList();
	}

	@Override
	public void deleteNewsFromTitle(String title) {
		// TODO Auto-generated method stub
		newsRep.deleteNewsFromTitle(title);

	}

	@Override
	public News getNewsFromTitle(String title) {
		// TODO Auto-generated method stub
		return newsRep.getNewsFromTitle(title);
	}

	@Override
	public void updateNews(Long id, String title, String description, String image, String date, boolean isActive) {
		// TODO Auto-generated method stub
		System.out.println(title);
		newsRep.updateNews(id, title, description, image, date, isActive);

	}

	@Override
	public Student getStudentFromName(String studentName) {
		System.out.println("GetStudent FromName");
		if (studentRep.getStudentFromName(studentName) == null)
			throw new RuntimeException("étudiant non trouvable");
		else
			return studentRep.getStudentFromName(studentName);
	}

	@Override
	public Teacher getTeacherFromName(String teacherName) {
		System.out.println("GetTeacher FromName");
		if (teacherRep.getTeacherFromName(teacherName) == null)
			throw new RuntimeException("enseignant non trouvable");
		else
			return teacherRep.getTeacherFromName(teacherName);
	}

	@Override
	public Admin getAdminFromName(String adminName) {
		System.out.println("GetAdmin FromName");
		if (adminRep.getAdminFromName(adminName) == null)
			throw new RuntimeException("admin non trouvable");
		else
			return adminRep.getAdminFromName(adminName);
	}

	@Override
	public List<Teacher> getTeacherList() {
		return teacherRep.getTeacherList();
	}

	@Override
	public List<Course> getCourseList() {
		return courseRep.getCourseList();
	}

	@Override
	public List<Course> getCourseListByTeacher(Long teacher) {
		return courseRep.getCourseListByTeacher(teacher);
	}

	@Override
	public GroupClass getClassFromName(String className) {
		System.out.println("GetClass FromName");
		if (classRep.getClassFromName(className) == null)
			throw new RuntimeException("class not found");
		else
			return classRep.getClassFromName(className);
	}
}
