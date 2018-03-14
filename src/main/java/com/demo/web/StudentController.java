package com.demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.Metier.IntranetMetierInterface;
import com.demo.entities.News;
import com.demo.staticClasses.Mean;

@Controller
@RequestMapping("student")

class StudentController {
	@Autowired
	private IntranetMetierInterface interfaceMetier;

	
	public String message = "student";
	public Long id;
	@RequestMapping("/")
	public String empty(Model model , HttpServletRequest request, HttpServletResponse response)
	{
		model.addAttribute("profile", message) ;
		
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
		return "homeLogged" ; 
	}
		
	@RequestMapping("/home")
	public String home(Model model , HttpServletRequest request, HttpServletResponse response)
	{
		model.addAttribute("profile", message) ;
		
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
		return "homeLogged" ; 
	}
	
	
	@RequestMapping("/news")
	public String news(Model model )
	{
		model.addAttribute("profile", message) ;
		List<News> newsList = new ArrayList<>();
		for (News news : interfaceMetier.getNewsList())
			newsList.add(news);
		
		model.addAttribute("news", newsList);
		return "news" ; 
	}
	
	@RequestMapping("/marks")
	public String marks(Model model )
	{
		List<Mean> meanList = new ArrayList<>();

		for (Mean mean : interfaceMetier.getStudentsMeanFromId((long) 1)) {
			meanList.add(mean);
		}
		model.addAttribute("meanList", meanList) ;

		model.addAttribute("profile", message) ;
		return "marks" ; 
	}
	
	@RequestMapping("/timeTable")
	public String timeTable(Model model )
	{
		model.addAttribute("profile", message) ;
		return "timeTable" ; 
	}

}
