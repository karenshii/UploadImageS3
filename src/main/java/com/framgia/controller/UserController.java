package com.framgia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.framgia.bean.ShopInfo;
import com.framgia.bean.UserInfo;
import com.framgia.model.User;
import com.framgia.service.IShopService;
import com.framgia.service.IUserService;
import com.framgia.util.Helpers;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IShopService shopService;

	@RequestMapping(value = "/user")
	public String findAllUser(Model model) {
		List<UserInfo> userInfoList = userService.findAll();
		if (!Helpers.isEmpty(userInfoList)) {
			model.addAttribute("userInforList", userInfoList);
		} else {
			model.addAttribute("userInforList", "Empty");
		}
		return "user";
	}

	@RequestMapping(value = "/addUser")
	public String addUser(Model model) {
		UserInfo obj = new UserInfo();
		model.addAttribute("userForm", obj);
		List<ShopInfo> listShop = shopService.getListShop();
		model.addAttribute("listShop", listShop);
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(Model model, @ModelAttribute(value = "userForm") UserInfo userForm,
			BindingResult result) {
		boolean check = true;
		
		if (Helpers.isEmpty(userForm.getPassword())) {
			result.reject("password", "password is not empty");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getRole().toString())) {
			result.reject("role", "role is not empty");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getStatus().toString())) {
			result.reject("status", "status is not empty");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getUsername())) {
			result.reject("username", "username is not empty");
			check = false;
		}
		if (!check) {
			return new ModelAndView("addUser");
		}
		
		userService.addUser(userForm);
		return new ModelAndView("redirect:user");
	}

}
