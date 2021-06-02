package com.rays.cts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rays.cts.model.User;
import com.rays.cts.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	User user;
	
	String msg = "";
	
	@RequestMapping("/")
	public String init() {
		return "redirect:/login";
	}

	@RequestMapping("/users")
	public String home(Model model) {
		model.addAttribute("users", userService.getAll());
		return "users";
	}

	@RequestMapping("/register-page")
	public String showform(ModelMap map) {
		map.addAttribute("addUser", user);
		map.addAttribute("addMsg", "");
		return "register-page"; // view element
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveTrainee(@ModelAttribute("addUser") User user, ModelAndView mv) {
		userService.addUser(user);
		mv.addObject("addMsg", "User Added Successfully");
		mv.setViewName("register-page");
		return mv;
	}
	
	@RequestMapping("/login")
	public String showLogin(ModelMap map) {
		map.addAttribute("addUser", user);
		map.addAttribute("addMsg", msg);
		return "login"; // view element
	}

	@RequestMapping("/loginCheck")
	public String loginCheck(@ModelAttribute("addUser") User user, Model m) {
		User user1 = userService.getById(user.getId(), user.getPass());
		if(user1!=null) {
			//m.addAttribute("addMsg", "Login Successfully");		
		return "redirect:/users";
		}
		else {
			msg =  "Login Failed";		
			return "redirect:/login";
		}
			
	}
}