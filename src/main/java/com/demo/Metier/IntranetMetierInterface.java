package com.demo.Metier;

import java.util.List;

import com.demo.entities.*;
import com.demo.staticClasses.Mean;


public interface IntranetMetierInterface {
	

	public Admin getAdminFromName(String adminName);
	public void createAdmin(String name, String username, String password);
	public void createStudent(String name, String username, String password, GroupClass studentClass);
	public void createTeacher(String name, String username, String password);
	public void createNews(String title, String description, String image, String date, boolean isActive);
	List<GroupClass> getGroupClassList();
	List<News> getNewsList();
	List<News> getLatestNewsList();
	public void deleteNewsFromTitle(String title);
	public News getNewsFromTitle(String title);
	public void updateNews(Long id, String title, String description, String image, String date, boolean isActive);
	public Student getStudentFromName(String studentName);
	public Teacher getTeacherFromName(String teacherName);
	public GroupClass getClassFromName(String className);

	List<Teacher> getTeacherList();
	List<Course> getCourseList(); 
	List<Course> getCourseListByTeacher(Long teacher); 
	public List<Object[]> getCourseClass(String id);
	public List<String> getStudentFromClassName(String name);
	public Course getCourseFromName(String courseName);
	public Student getStudentFromUsername(String username);
	public void createMark(Student student, Course course, int mark);
	public List<Mean> getStudentsMeanFromId(Long studentId);

}
