package com.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IntranetController{
	public String message = "admin";
	@RequestMapping("navbar")
	public String navbar(Model model )
	{
		model.addAttribute("profile", message) ;
		return "navbar" ; 
	}
	
	@RequestMapping("/home")
	public String home(Model model )
	{
		model.addAttribute("profile", message) ;
		return "homeLogged" ; 
	}
	
	@RequestMapping("/marks")
	public String marks(Model model )
	{
		model.addAttribute("profile", message) ;
		return "marks" ; 
	}
	

	@RequestMapping("/news")
	public String news(Model model )
	{
		model.addAttribute("profile", message) ;
		return "news" ; 
	}
	
	@RequestMapping("/timeTable")
	public String timeTable(Model model )
	{
		model.addAttribute("profile", message) ;
		return "timeTable" ; 
	}
	
	@RequestMapping("/accountManage")
	public String accountManage(Model model )
	{
		model.addAttribute("profile", message) ;
		return "accountManage" ; 
	}
	
	@RequestMapping("/marksManage")
	public String marksManage(Model model )
	{
		model.addAttribute("profile", message) ;
		return "marksManage" ; 
	}
	
	@RequestMapping("/newsManage")
	public String newsManage(Model model )
	{
		model.addAttribute("profile", message) ;
		return "newsManage" ; 
	}
	
	@RequestMapping("/timeTableManage")
	public String timeTableManage(Model model )
	{
		model.addAttribute("profile", message) ;
		return "timeTableManage" ; 
	}
}