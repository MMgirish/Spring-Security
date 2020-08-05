package com.ons.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
	
//	@GetMapping (value = "/dashboard")
//	public ModelAndView HomePage() {
//		ModelAndView modelView= new ModelAndView();
//		modelView.setViewName("dashboard.html");
//		return modelView;
//	}
//	
//	@GetMapping (value = "/admin")
//	public ModelAndView AdminPage() {
//		ModelAndView modelAndView= new ModelAndView();
//		modelAndView.setViewName("admin.html");
//		return modelAndView;
//	}
	
	@GetMapping(value = "/dashboard.jsf")
	public String HomePage() {
		return "dashboard?faces-redirect=true";
	}
	
	@GetMapping(value = "/admin.jsf")
	public String AdminPage() {
		return "admin?faces-redirect=true";
	}
	
	@GetMapping(value = "/admin/viewList.jsf")
	public String ViewList() {
		return "viewList?faces-redirect=true";
	}

}
