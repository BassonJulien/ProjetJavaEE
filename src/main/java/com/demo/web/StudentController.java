package com.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.Metier.IntranetMetierInterface;
import com.demo.entities.News;

@Controller
@RequestMapping("student")

class StudentController {
	@Autowired
	private IntranetMetierInterface interfaceMetier;

	
	public String message = "student";

	@RequestMapping("/")
	public String empty(Model model )
	{
		model.addAttribute("profile", message) ;
		List<News> newsList = new ArrayList<>();
		for (News news : interfaceMetier.getLatestNewsList())
			newsList.add(news);
		
		model.addAttribute("news", newsList);
		return "homeLogged" ; 
	}
		
	@RequestMapping("/home")
	public String home(Model model )
	{
		model.addAttribute("profile", message) ;
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
