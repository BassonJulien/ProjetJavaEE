package com.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")

class StudentController {
	
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
