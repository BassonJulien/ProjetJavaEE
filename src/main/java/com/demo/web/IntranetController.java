package com.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IntranetController{
	
	@RequestMapping("navbar")
	public String navbar(Model model )
	{
		String message = "admin" ;
		model.addAttribute("profile", message) ;
		return "navbar" ; 
	}
	
	@RequestMapping("/home")
	public String home(Model model )
	{
		String message = "student" ;
		model.addAttribute("profile", message) ;
		return "home" ; 
	}
	
	@RequestMapping("/marks")
	public String marks(Model model )
	{
		String message = "admin" ;
		model.addAttribute("profile", message) ;
		return "marks" ; 
	}
	

	@RequestMapping("/news")
	public String news(Model model )
	{
		String message = "admin" ;
		model.addAttribute("profile", message) ;
		return "news" ; 
	}
	
	@RequestMapping("/timeTable")
	public String timeTable(Model model )
	{
		String message = "admin" ;
		model.addAttribute("profile", message) ;
		return "timeTable" ; 
	}
	
	@RequestMapping("/accountManage")
	public String accountManage(Model model )
	{
		String message = "admin" ;
		model.addAttribute("profile", message) ;
		return "accountManage" ; 
	}
	
	@RequestMapping("/marksManage")
	public String marksManage(Model model )
	{
		String message = "admin" ;
		model.addAttribute("profile", message) ;
		return "marksManage" ; 
	}
	
	@RequestMapping("/newsManage")
	public String newsManage(Model model )
	{
		String message = "admin" ;
		model.addAttribute("profile", message) ;
		return "newsManage" ; 
	}
	
	@RequestMapping("/timeTableManage")
	public String timeTableManage(Model model )
	{
		String message = "admin" ;
		model.addAttribute("profile", message) ;
		return "timeTableManage" ; 
	}
}