package com.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IntranetController{
	
	@RequestMapping("/index")
	public String index(Model model )
	{
		String message = "Bienvenue a votre Banque" ;
		model.addAttribute("msgBienvenue", message) ;
		return "index" ; 
	}
}