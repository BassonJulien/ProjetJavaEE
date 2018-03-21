package com.demo.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Metier.IntranetMetierInterface;
import com.demo.dao.CourseRepository;
import com.demo.entities.*;
import com.demo.staticClasses.*;

import com.demo.validators.NewNewsFormValidator;
import com.demo.validators.NewUserFormValidator;
import com.mysql.fabric.xmlrpc.base.Member;

@Controller
@RequestMapping("admin")

public class AdminController {
	public String message = "admin";
	public String title;
	public Long newsId;
	@Autowired
	private IntranetMetierInterface interfaceMetier;
	@Autowired
	private CourseRepository courseRep;

	@RequestMapping(value={"/home", "/"})
	public String empty(Model model) {
		model.addAttribute("profile", message);
		List<News> newsList = new ArrayList<>();
		for (News news : interfaceMetier.getLatestNewsList())
			newsList.add(news);

		model.addAttribute("news", newsList);

		return "homeLogged";
	}

	@RequestMapping("/accountManage")
	public String accountManage(Model model) {
		model.addAttribute("profile", message);
		return "accountManage";
	}

	@RequestMapping(value = "/accountManage", method = RequestMethod.GET)
	public String requestInfo(Model model) {
		model.addAttribute("userValidator", new NewUserFormValidator());
		model.addAttribute("profile", message);

		List<String> classNameList = new ArrayList<>();

		for (GroupClass groupClass : interfaceMetier.getGroupClassList())
			classNameList.add(groupClass.getName());

		model.addAttribute("classNameList", classNameList);

		return "accountManage";
	}

	@RequestMapping(value = "/accountManage", method = RequestMethod.POST)
	String requestInfo(Model model, @Valid @ModelAttribute("userValidator") NewUserFormValidator userValidator,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "accountManage";
		}

		model.addAttribute("profile", message);
		String profile = userValidator.getProfile();

		if (profile.equals("student")) {

			GroupClass class1 = new GroupClass();

			interfaceMetier.createStudent(userValidator.getName(), userValidator.getEmail(),
					userValidator.getPassword(), class1);
			return "redirect:/admin/home";
		}
		if (profile.equals("teacher")) {
			interfaceMetier.createTeacher(userValidator.getName(), userValidator.getEmail(),
					userValidator.getPassword());
			return "redirect:/admin/home";
		}
		if (profile.equals("admin")) {
			interfaceMetier.createAdmin(userValidator.getName(), userValidator.getEmail(), userValidator.getPassword());

			return "redirect:/admin/home";
		}

		return "accountManage";

	}

	@RequestMapping(value = "/updateNews", params = "delete", method = RequestMethod.POST)
	public String action1(@RequestParam("delete") String title) {
		this.title = title;
		interfaceMetier.deleteNewsFromTitle(title);
		return "redirect:/admin/newsManage";
	}

	@RequestMapping(value = "/updateNews", params = "update", method = RequestMethod.POST)
	public String action2(@RequestParam("update") String title, Model model) {
		this.title = title;

		News news = interfaceMetier.getNewsFromTitle(this.title);

		model.addAttribute("title", this.title);
		model.addAttribute("profile", message);
		model.addAttribute("description", news.getDescription());
		model.addAttribute("image", news.getImage());
		model.addAttribute("isActive", news.isActive());
		model.addAttribute("date", news.getDate());
		model.addAttribute("newsValidator", new NewNewsFormValidator());
		model.addAttribute("newsId", news.getIdNews());
		this.newsId = news.getIdNews();

		return "newsUpdate";
	}

	@RequestMapping(value = "/updateNews", method = RequestMethod.POST)
	public String action3(Model model, @Valid @ModelAttribute("newsValidator") NewNewsFormValidator newsValidator,
			BindingResult bindingResult) {
		interfaceMetier.updateNews(this.newsId, newsValidator.getTitle(), newsValidator.getDescription(),
				newsValidator.getImage(), newsValidator.getDate(), newsValidator.isActive());
		return "redirect:/admin/newsManage";
	}

	@RequestMapping(value = "/newsManage", method = RequestMethod.GET)
	public String newManage(Model model) {
		model.addAttribute("newsValidator", new NewNewsFormValidator());
		model.addAttribute("profile", message);

		List<News> news = interfaceMetier.getNewsList();
		model.addAttribute("news", news);

		return "newsManage";
	}

	@RequestMapping(value = "/newsManage", method = RequestMethod.POST)
	String newManage(Model model, @Valid @ModelAttribute("newsValidator") NewNewsFormValidator newsValidator,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "newsManage";
		}
		interfaceMetier.createNews(newsValidator.getTitle(), newsValidator.getDescription(), newsValidator.getImage(),
				newsValidator.getDate(), newsValidator.isActive());

		return "redirect:/admin/newsManage";

	}

	@RequestMapping(value = "/timeTableManage", method = RequestMethod.GET)
	public String getTimeTableManage(Model model) {
		// initiate value for selector
		String textSummary = "";
		String p_teacherSelected = null;
		String p_courseNameSelected = null;
		String p_classNameSelected = null;
		String p_courseDaySelected = null;
		String p_hoursDaySelected = null;

		// add attribute to the jsp
		model.addAttribute("valueButton", "visualize");
		model.addAttribute("textSummary", textSummary);
		model.addAttribute("profile", message);
		model.addAttribute("teacherSelected", p_teacherSelected);
		model.addAttribute("courseNameSelected", p_courseNameSelected);
		model.addAttribute("classNameSelected", p_classNameSelected);
		model.addAttribute("courseDaySelected", p_courseDaySelected);
		model.addAttribute("hoursDaySelected", p_hoursDaySelected);

		// initiate list variable for the dropdown list
		List<Teacher> teachers = interfaceMetier.getTeacherList();
		List<String> teachersNames = new ArrayList<>();
		List<String> classNameList = new ArrayList<>();
		List<String> courseNameList = new ArrayList<>();
		List<String> courseDayList = new ArrayList<>();
		List<String> hoursDayList = new ArrayList<>();

		// hours list
		hoursDayList.add("08AM");
		hoursDayList.add("10AM");
		hoursDayList.add("12AM");
		hoursDayList.add("2PM");
		hoursDayList.add("4PM");
		hoursDayList.add("6PM");
		// day list
		courseDayList.add("Monday");
		courseDayList.add("Tuesday");
		courseDayList.add("Wednesday");
		courseDayList.add("Thursday");
		courseDayList.add("Friday");

		// get all class name
		for (GroupClass groupClass : interfaceMetier.getGroupClassList())
			classNameList.add(groupClass.getName());
		// get all course name
		// for (Course course : interfaceMetier.getCourseList()) {
		// courseNameList.add(course.getName());
		// }
		// Course name List
		courseNameList.add("Ember");
		courseNameList.add("J2EE");
		courseNameList.add("BDD");
		courseNameList.add("DEVOPS");
		courseNameList.add("ART");
		// get all teachers
		for (Teacher teacher : teachers) {
			teachersNames.add(teacher.getName() + " " + teacher.getUsername());
		}

		// set all attributes to the jsp
		model.addAttribute("teachers", teachersNames);
		model.addAttribute("classNameList", classNameList);
		model.addAttribute("courseNameList", courseNameList);
		model.addAttribute("courseDayList", courseDayList);
		model.addAttribute("hoursDayList", hoursDayList);

		return "timeTableManage";
	}

	@RequestMapping(value = "/timeTableManage", method = RequestMethod.POST)
	public String postTimeTableManage(Model model, @ModelAttribute("valueButton") String valueButton,
			@ModelAttribute("teachers") String p_teacherSelected,
			@ModelAttribute("classNameList") String p_classNameSelected,
			@ModelAttribute("courseNameList") String p_courseNameSelected,
			@ModelAttribute("courseDayList") String p_courseDaySelected,
			@ModelAttribute("hoursDayList") String p_hoursDaySelected) {

		// text summay when u register the course
		String textSummary = "You choose " + p_teacherSelected + " teacher" + " who anims the course of "
				+ p_courseNameSelected + " for the class " + p_classNameSelected + " on " + p_courseDaySelected + " at "
				+ p_hoursDaySelected;
		Boolean visualize = true;
		// id of the teacher selected to find the teacher course list
		Teacher teacherSelected = interfaceMetier.getTeacherFromName(p_teacherSelected.split(" ")[1]);
		List<Course> courseListByTeacher = interfaceMetier.getCourseListByTeacher(teacherSelected.getIdTeacher());
		GroupClass courseSelected = interfaceMetier.getClassFromName(p_classNameSelected);
		
		// initiate variable
		List<Teacher> teachers = interfaceMetier.getTeacherList();
		List<String> teachersNames = new ArrayList<>();
		List<String> classNameList = new ArrayList<>();
		List<String> courseNameList = new ArrayList<>();
		List<String> courseDayList = new ArrayList<>();
		List<String> hoursDayList = new ArrayList<>();
		List<String> courseNameListByTeacher = new ArrayList<>();
		List<String> courseDayListByTeacher = new ArrayList<>();
		List<String> courseHoursListByTeacher = new ArrayList<>();
		List<String> courseClassNameListByTeacher = new ArrayList<>();
		List<String> courseSortedByDay = new ArrayList<>();
		List<TimeSlot> timeSlotList = new ArrayList<>();

		//
		List<String> heightAM = new ArrayList<>();
		List<String> tenAM = new ArrayList<>();
		List<String> noon = new ArrayList<>();
		List<String> twoPM = new ArrayList<>();
		List<String> fourPM = new ArrayList<>();
		List<String> sixPM = new ArrayList<>();
		List<String> days = new ArrayList<>();

		// hours list
		hoursDayList.add("08AM");
		hoursDayList.add("10AM");
		hoursDayList.add("12AM");
		hoursDayList.add("2PM");
		hoursDayList.add("4PM");
		hoursDayList.add("6PM");
		// day list
		courseDayList.add("Monday");
		courseDayList.add("Tuesday");
		courseDayList.add("Wednesday");
		courseDayList.add("Thursday");
		courseDayList.add("Friday");

		// Course name List
		courseNameList.add("Ember");
		courseNameList.add("J2EE");
		courseNameList.add("BDD");
		courseNameList.add("DEVOPS");
		courseNameList.add("ART");

		// Days list
		days.add("monday");
		days.add("tuesday");
		days.add("wednesday");
		days.add("thursday");
		days.add("friday");

		// get all class name
		for (GroupClass groupClass : interfaceMetier.getGroupClassList())
			classNameList.add(groupClass.getName());
		for (Teacher teacher : teachers) {
			teachersNames.add(teacher.getName() + " " + teacher.getUsername());
		}
		// get all course name of the teacher
		for (Course course : courseListByTeacher)
			courseNameListByTeacher.add(course.getName());

		// get all course name of the teacher
		for (Course course : courseListByTeacher)
			courseDayListByTeacher.add(course.getDay());

		// get all course name of the teacher
		for (Course course : courseListByTeacher)
			courseHoursListByTeacher.add(course.getHours());

		// get all course name of the teacher
		for (Course course : courseListByTeacher)
			courseClassNameListByTeacher.add(course.getClass().getName());

		courseListByTeacher.sort(Comparator.comparing(Course::getHours));
		if(valueButton.equals("add")) {
			visualize = false;
		}
		if (visualize) {
			for (Course course : courseListByTeacher) {
				courseSortedByDay.add(course.getDay() + "-" + course.getHours() + "-" + course.getName() + "-");
				System.out.println("courseday  " + course);
				if (course.getDay().equals("Monday")) {
					System.out.println("courseday  ");

					timeSlotList.add(new TimeSlot(course.getHours(), course.getName()+" "+course.getClassCourse().getName() + "-" + course.getHours(), null,
							null, null, null));
				}
				if (course.getDay().equals("Tuesday")) {
					System.out.println("courseday  ");

					timeSlotList.add(new TimeSlot(course.getHours(), null, course.getName()+" "+course.getClassCourse().getName() + "-" + course.getHours(),
							null, null, null));
				}
				if (course.getDay().equals("Wednesday")) {
					System.out.println("courseday  ");

					timeSlotList.add(new TimeSlot(course.getHours(), null, null,
							course.getName()+" "+course.getClassCourse().getName() + "-" + course.getHours(), null, null));
				}
				if (course.getDay().equals("Thursday")) {
					System.out.println("courseday  ");

					timeSlotList.add(new TimeSlot(course.getHours(), null, null, null,
							course.getName()+" "+course.getClassCourse().getName() + "-" + course.getHours(), null));
				}
				if (course.getDay().equals("Friday")) {
					System.out.println("courseday  ");

					timeSlotList.add(new TimeSlot(course.getHours(), null, null, null, null,
							course.getName()+" "+course.getClassCourse().getName() + "-" + course.getHours()));
				}

			}
			timeSlotList.sort(Comparator.comparing(TimeSlot::getName));

			for (String day : days) {
				heightAM.add(day);
				tenAM.add(day);
				noon.add(day);
				twoPM.add(day);
				fourPM.add(day);
				sixPM.add(day);
			}
			for (TimeSlot slot : timeSlotList) {
				for (String item : heightAM) {
					if (item.equals("monday") && slot.getMonday() != null && slot.getMonday().split("-")[1].equals("08AM")) {
						heightAM.set(0,slot.getMonday()+"monday");
					}
					if (item.equals("tuesday") && slot.getTuesday() != null && slot.getTuesday().split("-")[1].equals("08AM")) {
						heightAM.set(1,slot.getTuesday()+"tuesday");
					}
					
					if (item.equals("wednesday") && slot.getWednesday() != null && slot.getWednesday().split("-")[1].equals("08AM")) {
						heightAM.set(2,slot.getWednesday()+"wednesday");
					}
					
					if (item.equals("thursday") && slot.getThursday() != null && slot.getThursday().split("-")[1].equals("08AM")) {
						heightAM.set(3,slot.getThursday()+"thursday");
					}
					
					if (item.equals("friday") && slot.getFriday() != null && slot.getFriday().split("-")[1].equals("08AM")) {
						heightAM.set(4,slot.getFriday()+"friday");
					}
				}
			}
			for (TimeSlot slot : timeSlotList) {
				for (String item : tenAM) {
					if (item.equals("monday") && slot.getMonday() != null && slot.getMonday().split("-")[1].equals("10AM")) {
						tenAM.set(0,slot.getMonday()+"monday");
					}
					
					if (item.equals("tuesday") && slot.getTuesday() != null && slot.getTuesday().split("-")[1].equals("10AM")) {
						tenAM.set(1,slot.getTuesday()+"tuesday");
					}
					
					if (item.equals("wednesday") && slot.getWednesday() != null && slot.getWednesday().split("-")[1].equals("10AM")) {
						tenAM.set(2,slot.getWednesday()+"wednesday");
					}
					
					if (item.equals("thursday") && slot.getThursday() != null && slot.getThursday().split("-")[1].equals("10AM")) {
						tenAM.set(3,slot.getThursday()+"thursday");
					}
					
					if (item.equals("friday") && slot.getFriday() != null && slot.getFriday().split("-")[1].equals("10AM")) {
						tenAM.set(4,slot.getFriday()+"friday");
					}
				}
			}
			for (TimeSlot slot : timeSlotList) {
				for (String item : noon) {
					if (item.equals("monday") && slot.getMonday() != null && slot.getMonday().split("-")[1].equals("12AM")) {
						noon.set(0,slot.getMonday()+"monday");
					}
					
					if (item.equals("tuesday") && slot.getTuesday() != null && slot.getTuesday().split("-")[1].equals("12AM")) {
						noon.set(1,slot.getTuesday()+"tuesday");
					}
					
					if (item.equals("wednesday") && slot.getWednesday() != null && slot.getWednesday().split("-")[1].equals("12AM")) {
						noon.set(2,slot.getWednesday()+"wednesday");
					}
					
					if (item.equals("thursday") && slot.getThursday() != null && slot.getThursday().split("-")[1].equals("12AM")) {
						noon.set(3,slot.getThursday()+"thursday");
					}
					
					if (item.equals("friday") && slot.getFriday() != null && slot.getFriday().split("-")[1].equals("12AM")) {
						noon.set(4,slot.getFriday()+"friday");
					}
				}
			}
			for (TimeSlot slot : timeSlotList) {
				for (String item : twoPM) {
					if (item.equals("monday") && slot.getMonday() != null && slot.getMonday().split("-")[1].equals("2PM")) {
						twoPM.set(0,slot.getMonday()+"monday");
					}
					
					if (item.equals("tuesday") && slot.getTuesday() != null && slot.getTuesday().split("-")[1].equals("2PM")) {
						twoPM.set(1,slot.getTuesday()+"tuesday");
					}
					
					if (item.equals("wednesday") && slot.getWednesday() != null && slot.getWednesday().split("-")[1].equals("2PM")) {
						twoPM.set(2,slot.getWednesday()+"wednesday");
					}
					
					if (item.equals("thursday") && slot.getThursday() != null && slot.getThursday().split("-")[1].equals("2PM")) {
						twoPM.set(3,slot.getThursday()+"thursday");
					}
					
					if (item.equals("friday") && slot.getFriday() != null && slot.getFriday().split("-")[1].equals("2PM")) {
						twoPM.set(4,slot.getFriday()+"friday");
					}
				}
			}
			for (TimeSlot slot : timeSlotList) {
				for (String item : fourPM) {
					if (item.equals("monday") && slot.getMonday() != null && slot.getMonday().split("-")[1].equals("4PM")) {
						fourPM.set(0,slot.getMonday()+"monday");
					}
					
					if (item.equals("tuesday") && slot.getTuesday() != null && slot.getTuesday().split("-")[1].equals("4PM")) {
						fourPM.set(1,slot.getTuesday()+"tuesday");
					}
					
					if (item.equals("wednesday") && slot.getWednesday() != null && slot.getWednesday().split("-")[1].equals("4PM")) {
						fourPM.set(2,slot.getWednesday()+"wednesday");
					}
					
					if (item.equals("thursday") && slot.getThursday() != null && slot.getThursday().split("-")[1].equals("4PM")) {
						fourPM.set(3,slot.getThursday()+"thursday");
					}
					
					if (item.equals("friday") && slot.getFriday() != null && slot.getFriday().split("-")[1].equals("4PM")) {
						fourPM.set(4,slot.getFriday()+"friday");
					}
				}
			}
			for (TimeSlot slot : timeSlotList) {
				for (String item : sixPM) {
					if (item.equals("monday") && slot.getMonday() != null && slot.getMonday().split("-")[1].equals("6PM")) {
						sixPM.set(0,slot.getMonday()+"monday");
					}
					
					if (item.equals("tuesday") && slot.getTuesday() != null && slot.getTuesday().split("-")[1].equals("6PM")) {
						sixPM.set(1,slot.getTuesday()+"tuesday");
					}
					
					if (item.equals("wednesday") && slot.getWednesday() != null && slot.getWednesday().split("-")[1].equals("6PM")) {
						sixPM.set(2,slot.getWednesday()+"wednesday");
					}
					
					if (item.equals("thursday") && slot.getThursday() != null && slot.getThursday().split("-")[1].equals("6PM")) {
						sixPM.set(3,slot.getThursday()+"thursday");
					}
					
					if (item.equals("friday") && slot.getFriday() != null && slot.getFriday().split("-")[1].equals("6PM")) {
						sixPM.set(4,slot.getFriday()+"friday");
					}
				}
			}

		} else{
			Course course = courseRep.save(new Course(p_courseNameSelected, p_courseDaySelected, p_hoursDaySelected,
					teacherSelected, courseSelected));
		}

//		for (String slot : tenAM) {
//
//			System.out.println("yolo  " + slot);
//
//		}

		hoursDayList.sort(String::compareToIgnoreCase);
		for (String hours : hoursDayList)
			System.out.println(hours);
		// set all attributes to the jsps
		model.addAttribute("teachers", teachersNames);
		model.addAttribute("classNameList", classNameList);
		model.addAttribute("courseNameList", courseNameList);
		model.addAttribute("courseDayList", courseDayList);
		model.addAttribute("hoursDayList", hoursDayList);
		model.addAttribute("teacherSelected", p_teacherSelected);
		model.addAttribute("courseNameSelected", p_courseNameSelected);
		model.addAttribute("classNameSelected", p_classNameSelected);
		model.addAttribute("courseDaySelected", p_courseDaySelected);
		model.addAttribute("hoursDaySelected", p_hoursDaySelected);
		// permit to hidden or not the display
		model.addAttribute("visualize", visualize);
		model.addAttribute("textSummary", textSummary);
		model.addAttribute("profile", message);
		model.addAttribute("courseListByTeacher", courseListByTeacher);
		model.addAttribute("courseDayListByTeacher", courseDayListByTeacher);
		model.addAttribute("courseHoursListByTeacher", courseHoursListByTeacher);
		model.addAttribute("courseClassNameListByTeacher", courseClassNameListByTeacher);
		model.addAttribute("courseSortedByDay", courseSortedByDay);
		model.addAttribute("timeSlotList", timeSlotList);
		model.addAttribute("heightAM", heightAM);
		model.addAttribute("tenAM", tenAM);
		model.addAttribute("noon", noon);
		model.addAttribute("twoPM", twoPM);
		model.addAttribute("fourPM", fourPM);
		model.addAttribute("sixPM", sixPM);


		return "timeTableManage";
	}

}
