package com.demo.Metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.demo.dao.*;

import com.demo.entities.*;
import com.demo.staticClasses.Mean;

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

	@Autowired
	private MarkRepository markRep;
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
	public List<News> getLatestNewsList() {
		// TODO Auto-generated method stub
		return newsRep.getLatestNewsList();
	}

	@Override
	public List<Object[]> getCourseClass(String id) {
		// TODO Auto-generated method stub
		return courseRep.getCourseClassList(id);
	}

	@Override
	public List<Object[]> getStudentFromClassName() {
		// TODO Auto-generated method stub
		return studentRep.getStudentFromClassName();
	}

	@Override
	public Course getCourseFromName(String courseName) {
		// TODO Auto-generated method stub
		return courseRep.getCourseFromName(courseName);
	}

	@Override
	public Student getStudentFromUsername(String username) {
		// TODO Auto-generated method stub
		return studentRep.getStudentFromUsername(username);
	}

	@Override
	public void createMark(Student student, Course course, int mark) {
		// TODO Auto-generated method stub
		Mark newMark = markRep.save(new Mark(student, course, mark));

		
	}

	@Override
	public List<Mean> getStudentsMeanFromId(Long studentId) {
		// TODO Auto-generated method stub
		List<Object[]> objects = markRep.getStudentsMeanFromId(studentId);
		List<Mean> meanList = new ArrayList<>();
		List<Integer> markList = new ArrayList<Integer>();
		String markString ="";
		for (Object[] obj : objects ){
			for(float markObj : markRep.getStudentsMarksFromCourseName(obj[1].toString(), studentId) ) {
				markString+=" " + markObj;
			}
			System.out.println(obj[0].toString()+ " "+ studentId);
			meanList.add(new Mean((double)obj[0], obj[1].toString(), markString));
			markString="";
		}
		return meanList;
	}

}
