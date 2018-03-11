package com.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")

public class TeacherController {
	
	public String message = "student";

	
	@RequestMapping("/")
	public String empty(Model model )
	{
		model.addAttribute("profile", message) ;
		return "homeLogged" ; 
	}
		
	@RequestMapping("/home")
	public String home(Model model )
	{
		model.addAttribute("profile", message) ;
		return "homeLogged" ; 
	}
	
	@RequestMapping("/news")
	public String news(Model model )
	{
		model.addAttribute("profile", message) ;
		return "news" ; 
	}
	
	@RequestMapping("/marksManage")
	public String marksManage(Model model )
	{
		model.addAttribute("profile", message) ;
		return "marksManage" ; 
	}

}
