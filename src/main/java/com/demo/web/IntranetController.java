package com.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntranetController{
	public String message = "student";
	
	
	@RequestMapping("/")
	public String empty(Model model )
	{
		model.addAttribute("profile", message) ;
		return "homeUnlogged" ; 
	}
		
	@RequestMapping("/home")
	public String home(Model model )
	{
		model.addAttribute("profile", message) ;
		return "homeUnlogged" ; 
	}
		
}