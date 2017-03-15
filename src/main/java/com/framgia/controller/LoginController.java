package com.framgia.controller;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.framgia.util.Helpers;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String checkLogin(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		if(!Helpers.isEmpty(error)){
			model.addAttribute("error", "Invalid UserName and Password");
		}
		if(!Helpers.isEmpty(logout)){
			model.addAttribute("logout", "You've been logged out successfully.");
		}
		return "login";
	}

	@RequestMapping(value = "/403")
	public String errPage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)){
			UserDetails userDetail = (UserDetails) authentication.getPrincipal();
			model.addAttribute("user", userDetail.getUsername());
		}
		return "403";
	}

}
