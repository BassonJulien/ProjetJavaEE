package com.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	public String message = "student";
	
	@RequestMapping("/marks")
	public String marks(Model model )
	{
		model.addAttribute("profile", message) ;
		return "marks" ; 
	}


}
