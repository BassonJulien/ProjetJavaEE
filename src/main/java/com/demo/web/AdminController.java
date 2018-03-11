package com.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")

public class AdminController {
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
	
	@RequestMapping("/accountManage")
	public String accountManage(Model model )
	{
		model.addAttribute("profile", message) ;
		return "accountManage" ; 
	}

	
	@RequestMapping("/timeTableManage")
	public String timeTableManage(Model model )
	{
		model.addAttribute("profile", message) ;
		return "timeTableManage" ; 
	}
	
	@RequestMapping("/newsManage")
	public String newsManage(Model model )
	{
		model.addAttribute("profile", message) ;
		return "newsManage" ; 
	}
	

}
