package com.demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Metier.IntranetMetierInterface;
import com.demo.entities.GroupClass;
import com.demo.entities.News;
import com.demo.validators.NewNewsFormValidator;
import com.demo.validators.NewUserFormValidator;
import com.mysql.fabric.xmlrpc.base.Member;

@Controller
@RequestMapping("admin")

public class AdminController {
	public String message = "admin";
	public String title;
	public Long newsId;
	@Autowired
	private IntranetMetierInterface interfaceMetier;

	@RequestMapping("/")
	public String empty(Model model) {
		model.addAttribute("profile", message);
		return "homeLogged";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("profile", message);
		return "homeLogged";
	}

	@RequestMapping("/accountManage")
	public String accountManage(Model model) {
		model.addAttribute("profile", message);
		return "accountManage";
	}

	@RequestMapping(value = "/accountManage", method = RequestMethod.GET)
	public String requestInfo(Model model) {
		model.addAttribute("userValidator", new NewUserFormValidator());
		model.addAttribute("profile", message);

		List<String> classNameList = new ArrayList<>();

		for (GroupClass groupClass : interfaceMetier.getGroupClassList())
			classNameList.add(groupClass.getName());

		model.addAttribute("classNameList", classNameList);

		return "accountManage";
	}

	@RequestMapping(value = "/accountManage", method = RequestMethod.POST)
	String requestInfo(Model model, @Valid @ModelAttribute("userValidator") NewUserFormValidator userValidator,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "accountManage";
		}

		model.addAttribute("profile", message);
		String profile = userValidator.getProfile();

		if (profile.equals("student")) {

			GroupClass class1 = new GroupClass();

			interfaceMetier.createStudent(userValidator.getName(), userValidator.getEmail(),
					userValidator.getPassword(), class1);
			return "redirect:/admin/home";
		}
		if (profile.equals("teacher")) {
			interfaceMetier.createTeacher(userValidator.getName(), userValidator.getEmail(),
					userValidator.getPassword());
			return "redirect:/admin/home";
		}
		if (profile.equals("admin")) {
			interfaceMetier.createAdmin(userValidator.getName(), userValidator.getEmail(), userValidator.getPassword());

			return "redirect:/admin/home";
		}

		return "accountManage";

	}

	@RequestMapping("/timeTableManage")
	public String timeTableManage(Model model) {
		model.addAttribute("profile", message);
		return "timeTableManage";
	}

	@RequestMapping(value = "/updateNews", params = "delete", method = RequestMethod.POST)
	public String action1(@RequestParam("delete") String title) {
		this.title = title;
		interfaceMetier.deleteNewsFromTitle(title);
		return "redirect:/admin/newsManage";
	}

	@RequestMapping(value = "/updateNews", params = "update", method = RequestMethod.POST)
	public String action2(@RequestParam("update") String title, Model model) {
		this.title = title;

		News news = interfaceMetier.getNewsFromTitle(this.title);

		model.addAttribute("title", this.title);
		model.addAttribute("profile", message);
		model.addAttribute("description", news.getDescription());
		model.addAttribute("image", news.getImage());
		model.addAttribute("isActive", news.isActive());
		model.addAttribute("date", news.getDate());
		model.addAttribute("newsValidator", new NewNewsFormValidator());
		model.addAttribute("newsId", news.getIdNews());
		this.newsId = news.getIdNews();

		return "newsUpdate";
	}
	
	@RequestMapping(value = "/updateNews", method = RequestMethod.POST)
	public String action3(Model model, @Valid @ModelAttribute("newsValidator") NewNewsFormValidator newsValidator,
			BindingResult bindingResult) {
		interfaceMetier.updateNews(this.newsId, newsValidator.getTitle(), newsValidator.getDescription(), newsValidator.getImage(),
				newsValidator.getDate(), newsValidator.isActive());
		return "redirect:/admin/newsManage";
	}
/*
	@RequestMapping(value = "/sendModif", params = "delete", method = RequestMethod.POST)
	public String action3(@RequestParam("sendModif") NewNewsFormValidator newsValidator) {
		System.out.println(newsValidator.getTitle());
		return "redirect:/admin/newsManage";
	}*/

	/*@RequestMapping(value = "/newsUpdate", method = RequestMethod.POST)
	String newUpdateSent(Model model, @Valid @ModelAttribute("newsValidator") NewNewsFormValidator newsValidator,
			BindingResult bindingResult) {
		model.addAttribute("profile", message);
		System.out.println("CA marcher");

		return "redirect:/admin/home";
	}*/

	@RequestMapping(value = "/newsManage", method = RequestMethod.GET)
	public String newManage(Model model) {
		model.addAttribute("newsValidator", new NewNewsFormValidator());
		model.addAttribute("profile", message);

		List<News> news = interfaceMetier.getNewsList();
		model.addAttribute("news", news);

		return "newsManage";
	}

	@RequestMapping(value = "/newsManage", method = RequestMethod.POST)
	String newManage(Model model, @Valid @ModelAttribute("newsValidator") NewNewsFormValidator newsValidator,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "newsManage";
		}
		interfaceMetier.createNews(newsValidator.getTitle(), newsValidator.getDescription(), newsValidator.getImage(),
				newsValidator.getDate(), newsValidator.isActive());

		return "redirect:/admin/home";

	}

}
