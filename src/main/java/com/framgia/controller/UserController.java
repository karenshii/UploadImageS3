package com.framgia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framgia.bean.UserInfo;
import com.framgia.service.UserService;
import com.framgia.util.Helpers;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user")
	public String findAllUser(Model model){
		List<UserInfo> userInfoList = userService.findAll();
		if (!Helpers.isEmpty(userInfoList)) {
			model.addAttribute("userInforList", userInfoList);
		}
		else{
			model.addAttribute("userInforList", "Empty");
		}
		return "user";
	}
}
