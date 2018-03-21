package com.demo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
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

import com.demo.Metier.IntranetMetierInterface;
import com.demo.dao.MarkRepository;
import com.demo.entities.*;
import com.demo.validators.NewMarkValidator;

@Controller
@RequestMapping("teacher")

public class TeacherController {
	@Autowired
	private IntranetMetierInterface interfaceMetier;

	@Autowired
	private MarkRepository markRep;

	public String message = "teacher";
	public Long id;
	String classNameNewMark = "";
	String courseNameNewMark = "";


	@RequestMapping("/")
	public String empty(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("profile", message);

		Cookie[] cookies = request.getCookies();
		String nameCookie = "intranetEsmeCookie";

		if (!cookies.equals(null)) {
			Cookie actualCookie = null;
			for (int i = 0; i < cookies.length; i++) {
				String name = cookies[i].getName();
				String value = cookies[i].getValue();
				// Cookie recherché : partage dans l’objet request
				if (name.equals(nameCookie)) {
					System.out.println("get cookie" + name);
					actualCookie = cookies[i];
					// pathLink =
					break;
				}
			}

			if (actualCookie != null) {
				this.id = Long.valueOf(actualCookie.getValue().split("-")[1]).longValue();

			}
		}

		List<News> newsList = new ArrayList<>();
		for (News news : interfaceMetier.getLatestNewsList())
			newsList.add(news);

		model.addAttribute("news", newsList);
		return "homeLogged";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("profile", message);

		List<News> newsList = new ArrayList<>();
		for (News news : interfaceMetier.getLatestNewsList())
			newsList.add(news);

		model.addAttribute("news", newsList);

		return "homeLogged";
	}

	@RequestMapping("/news")
	public String news(Model model) {
		model.addAttribute("profile", message);

		List<News> newsList = new ArrayList<>();
		for (News news : interfaceMetier.getNewsList())
			newsList.add(news);

		model.addAttribute("news", newsList);
		return "news";
	}

	@RequestMapping(value = "/marksManage", method = RequestMethod.GET)
	public String marksManage(Model model) {
		model.addAttribute("profile", message);

		List<String> courseClassList = new ArrayList<>();
		for (Object courseClass[] : interfaceMetier.getCourseClass(/* this.id.toString() */"215"))
			courseClassList.add(" " + courseClass[0] + " - " + courseClass[1]);

		model.addAttribute("courseClass", courseClassList);

		model.addAttribute("defaultCourseClass", null);

		return "marksManage";
	}

	@RequestMapping(value = "/marksManage", method = RequestMethod.POST)
	public String marksManagePOST(Model model, @ModelAttribute("courseClass") String courseClass,
			@ModelAttribute("student") String student, @ModelAttribute("mark") String mark,
			@ModelAttribute("defaultCourseClass") String defaultClass) {
		// System.out.println(Pattern.matches("-+", markValidator.getCourseClass()));
		String studentName = "";
		

		List<String> courseClassList = new ArrayList<>();
		for (Object courseClass1[] : interfaceMetier.getCourseClass(/* this.id.toString() */"215"))
			courseClassList.add(" " + courseClass1[0] + " - " + courseClass1[1]);

		
		if (mark.equals("")) {
			model.addAttribute("courseClass", courseClassList);

			classNameNewMark = courseClass.split("-")[1].replaceAll("\\s+", "");

			courseNameNewMark = courseClass.split("-")[0].replaceAll("\\s+", "");

			model.addAttribute("defaultCourseClass", courseClass);
			List<String> studentList = new ArrayList<>();

			for (String student1 : interfaceMetier.getStudentFromClassName(classNameNewMark))
				studentList.add(student1);

			model.addAttribute("studentList", studentList);

			model.addAttribute("profile", message);

			return "marksManage";
		} else {


			Student student2 = interfaceMetier.getStudentFromUsername(student);
			Course course = interfaceMetier.getCourseFromName(courseNameNewMark);
			System.out.println("/"+ courseNameNewMark +"/");

			interfaceMetier.createMark(student2, course, Integer.parseInt(mark));

			model.addAttribute("profile", message);

			
			List<News> newsList = new ArrayList<>();
			for (News news : interfaceMetier.getLatestNewsList())
				newsList.add(news);

			model.addAttribute("news", newsList);
			
			return "homeLogged";

		}

	}
}
