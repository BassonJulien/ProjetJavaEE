package com.demo.web;

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
import com.demo.dao.StudentRepository;
import com.demo.entities.Admin;
import com.demo.entities.Student;
import com.demo.entities.Teacher;

@Controller
public class IntranetController {
	public String message = "student";
	
	@Autowired
	private IntranetMetierInterface metierInterface;
	@RequestMapping("/")
	public String empty(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("profile", message);
		Cookie[] cookies = request.getCookies();
		String nameCookie = "intranetEsmeCookie";
		String pathLink = "homeUnlogged";

		// Test if one cookie is actual to redirect the user without creds
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
				String profile = actualCookie.getValue().split("-")[0];
				pathLink = "redirect:/"+profile+"/home";
				System.out.println("cookie already existed");
				// Fixer la date d’expiration du cookie à 20 min (en sec)
				actualCookie.setMaxAge(60 * 20);
				// Ajouter le cookie à l’entête du réponse à construire
				response.addCookie(actualCookie);
			}
		}

		return pathLink;
	}

	@RequestMapping("/home")
	public String home(Model model) {

		model.addAttribute("profile", message);
		return "homeUnlogged";
	}
	@RequestMapping(value = "/PlanningCourseForm", method = RequestMethod.GET)
	public String getPlanningCourse(Model model) {
		System.out.println("les erreurs sont : ");
		model.addAttribute("profile", message);
		return "planningCourseForm";
	}
	@RequestMapping(value = "/PlanningCourseForm", method = RequestMethod.POST)
	public String postPlanningCourse(Model model) {

		model.addAttribute("profile", message);
		return "planningCourseForm";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
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

}