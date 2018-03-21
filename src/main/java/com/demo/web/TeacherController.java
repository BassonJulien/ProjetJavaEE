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
		model.addAttribute("markValidator", new NewMarkValidator());

		List<String> courseClassList = new ArrayList<>();
		for (Object courseClass[] : interfaceMetier.getCourseClass(this.id))
			courseClassList.add(" "+courseClass[0] + " - " + courseClass[1]);

		List<String> courseClassList1 = new ArrayList<>();
		for (Object courseClass[] : interfaceMetier.getCourseClass(this.id))
			courseClassList1.add(courseClass[1] + "");

		model.addAttribute("courseClass", courseClassList);

		List<String> studentList = new ArrayList<>();
		List<String> classList = new ArrayList<>();

		for (Object student[] : interfaceMetier.getStudentFromClassName()) {
			studentList.add(" " + student[0] + " - " + student[1]);
			classList.add(student[1] + "");
		}

		model.addAttribute("courseClass", courseClassList);
		model.addAttribute("courseClass1", courseClassList1);

		model.addAttribute("studentList", studentList);

		return "marksManage";
	}

	@RequestMapping(value = "/marksManage", method = RequestMethod.POST)
	public String marksManage(Model model, @Valid @ModelAttribute("markValidator") NewMarkValidator markValidator,
			BindingResult bindingResult) {
		// System.out.println(Pattern.matches("-+", markValidator.getCourseClass()));
		String studentName ="";
		String courseName="";
		Matcher m = Pattern.compile(Pattern.quote(" ") + "(.*?)" + Pattern.quote(" -"))
				.matcher(markValidator.getStudentClass());
		while (m.find()) {
			 studentName = m.group(1);
		}
		
		Matcher m1 = Pattern.compile(Pattern.quote(" ") + "(.*?)" + Pattern.quote(" -"))
				.matcher(markValidator.getCourseClass());
		while (m1.find()) {
			 courseName = m1.group(1);
		}
			Student student = interfaceMetier.getStudentFromUsername(studentName);
			
			Course course = interfaceMetier.getCourseFromName(courseName);
			
			System.out.println("/"+courseName+"/");


			
			interfaceMetier.createMark(student, course, markValidator.getMark());
			model.addAttribute("profile", message);

			return "homeLogged";
		}

	
}
