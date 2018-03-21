package com.demo.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Metier.IntranetMetierInterface;
import com.demo.dao.*;
import com.demo.entities.*;

@Controller
public class IntranetController {
	public String message = "student";
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
	@Autowired
	private IntranetMetierInterface metierInterface;
	@RequestMapping(value={"/home", "/"})
	public String empty(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("profile", message);
		Cookie[] cookies = request.getCookies();
		String nameCookie = "intranetEsmeCookie";
		String pathLink = "homeUnlogged";

		// Test if one cookie is actual to redirect the user without creds
		if (cookies != null) {
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
				String profile = actualCookie.getValue().split("-")[0];
				pathLink = "redirect:/"+profile+"/home";
				System.out.println("cookie already existed");
				// Fixer la date d’expiration du cookie à 20 min (en sec)
				actualCookie.setMaxAge(60 * 20);
				// Ajouter le cookie à l’entête du réponse à construire
				response.addCookie(actualCookie);
			}
		}
		List<News> newsList = new ArrayList<>();
		for (News news : metierInterface.getLatestNewsList())
			newsList.add(news);
		
		model.addAttribute("news", newsList);

		return pathLink;
	}

	@RequestMapping(value={"/home", "/"}, method = RequestMethod.POST)
	public String postLoginForm(@ModelAttribute("student") Student user, @ModelAttribute("profile") String profile,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		Cookie[] cookies = request.getCookies();
		String cookieId = "";
		Boolean isRegistered = false;
		String pathLink = "homeUnlogged";
		String nameCookie = "intranetEsmeCookie";
		Cookie actualCookie = null;
		String error = "";
		// try to find a student by username and check his password
		if (profile.equals("student")) {
			try {
				Student studentTemp = metierInterface.getStudentFromName(user.getUsername());
				String password = studentTemp.getPassword();
				cookieId = profile +"-"+ studentTemp.getIdStudent();
				if (password.equals(user.getPassword())) {
					System.out.println("le password de l'étudiant est bon");
					isRegistered = true;
					pathLink = "redirect:/student/home";
				}
				else error += " Mauvais mot de passe";
			} catch (Exception e) {
				System.err.println("IndexOutOfBoundsException: " + e.getMessage());
				error += " "+e.getMessage();
			}
		}
		// try to find a admin by username and check his password

		else if (profile.equals("admin")) {
			try {
				Admin adminTemp = metierInterface.getAdminFromName(user.getUsername());
				String password = adminTemp.getPassword();
				cookieId = profile +"-"+ adminTemp.getIdAdim();
				if (password.equals(user.getPassword())) {
					System.out.println("le password de l'admin est bon");
					isRegistered = true;
					pathLink = "redirect:/admin/home";

				}
				else error += " Mauvais mot de passe";

			} catch (Exception e) {
				System.err.println("IndexOutOfBoundsException: " + e.getMessage());
				error += " "+e.getMessage();

			}
		}
		// try to find a teacher by username and check his password

		else {
			try {
				Teacher teacherTemp = metierInterface.getTeacherFromName(user.getUsername());
				String password = teacherTemp.getPassword();
				cookieId = profile +"-"+ teacherTemp.getIdTeacher();
				if (password.equals(user.getPassword())) {
					System.out.println("le password de l'enseignant est bon");
					isRegistered = true;
					pathLink = "redirect:/teacher/home";
				}
				else error += " Mauvais mot de passe";

			} catch (Exception e) {
				System.err.println("IndexOutOfBoundsException: " + e.getMessage());
				error += " "+e.getMessage();

			}
		}
		// check if the cookie exist, else create it
		if (isRegistered) {
			System.out.println("isregistered");
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					String name = cookies[i].getName();
					String value = cookies[i].getValue();
					// Cookie recherché : partage dans l’objet request

					if (nameCookie.equals(name)) {
						System.out.println("get cookie" + name + value);
						actualCookie = cookies[i];
						break;
					}
				}
				if (actualCookie == null) {
					System.out.println("create new cookie");
					Cookie cookie = new Cookie(nameCookie, cookieId);
					// Fixer la date d’expiration du cookie à 20 min (en sec)
					cookie.setMaxAge(60 * 20);
					// Ajouter le cookie à l’entête du réponse à construire
					response.addCookie(cookie);
				} else {
					System.out.println("set a cookie");
					// Fixer la date d’expiration du cookie à 20 min (en sec)
					actualCookie.setMaxAge(60 * 20);
					// Ajouter le cookie à l’entête du réponse à construire
					response.addCookie(actualCookie);
				}
			}
		}
		System.out.println("les erreurs sont : "+error);

		model.addAttribute("error",error);

		return pathLink;
	}
	@RequestMapping("/initDB")
	public String initDatabase()
	{
		GroupClass class1 = classRep.save(new GroupClass("3CT"));
		GroupClass class2 = classRep.save(new GroupClass("3CI"));
		GroupClass class3 = classRep.save(new GroupClass("3CB"));
		
		
		
		Teacher teacher1 = teacherRep.save(new Teacher("Robin", "waxo", "1234"));
		Teacher teacher2 = teacherRep.save(new Teacher("Jribi", "salma", "1234"));
		Teacher teacher3 = teacherRep.save(new Teacher("Arcelier", "Fabien", "1234"));
		Teacher teacher4 = teacherRep.save(new Teacher("Herry", "Sebastien", "1234"));
		
		Admin admin1 = adminRep.save(new Admin("Dandoush", "abdu","1234"));
		Admin admin2 = adminRep.save(new Admin("sato", "nako","1234"));
		Admin admin3 = adminRep.save(new Admin("camelot", "lolo","1234"));

		
		Student student1 = studentRep.save(new Student("lolo", "camelot", "1234", class1));
		Student student2 = studentRep.save(new Student("juju", "chazz", "1234", class1));
		Student student3 = studentRep.save(new Student("tom", "toto", "1234", class2));
		Student student4 = studentRep.save(new Student("jade", "jadou", "1234", class2));
		Student student5 = studentRep.save(new Student("gary", "gaga", "1234", class3));
		
		Course course1 = courseRep.save(new Course("J2EE","Monday","08AM", teacher2, class1));
		Course course2 = courseRep.save(new Course("database","Tuesday","08AM", teacher3, class2));
		
		News news1 = newsRep.save(new News("Froideur", "Attention au froid, couvrez vous pour ne pas attraper froid", "https://www.chosesasavoir.com/wp-content/uploads/2017/01/polesud.jpg", "20/03/18",true));
		News news2 = newsRep.save(new News("Crypto", "G20 actualité, tenez vous au courant", "https://www.coinstaker.com/wp-content/uploads/2017/11/bitcoin-digital-currency.jpg", "20/03/18",true));
		
		Mark mark = markRep.save(new Mark(student1, course1, 5));
		

		return "redirect:/home";

	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String nameCookie = "intranetEsmeCookie";

		// Test if one cookie is actual to redirect the user without creds
		if (cookies != null) {
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
				String profile = actualCookie.getValue().split("-")[0];
				System.out.println("cookie already existed and delete it");
				// Fixer la date d’expiration du cookie à 20 min (en sec)
				actualCookie.setMaxAge(0);
				// Ajouter le cookie à l’entête du réponse à construire
				response.addCookie(actualCookie);
			}
		}

	
		return "redirect:/home";

	}

}