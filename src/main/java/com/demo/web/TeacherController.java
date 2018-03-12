package com.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.Metier.IntranetMetierInterface;
import com.demo.entities.News;

@Controller
@RequestMapping("teacher")

public class TeacherController {
	@Autowired
	private IntranetMetierInterface interfaceMetier;

	
	public String message = "teacher";

	
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
	
	@RequestMapping("/marksManage")
	public String marksManage(Model model )
	{
		model.addAttribute("profile", message) ;
		return "marksManage" ; 
	}

}
