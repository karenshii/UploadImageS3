package com.framgia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.bean.ShopInfo;
import com.framgia.service.IShopService;
import com.framgia.util.Helpers;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping(value="/shop")
public class ShopController {

	@Autowired
	private IShopService shopService;

	@RequestMapping(value = "/shop")
	public String findAllShop(Model model) {
		List<ShopInfo> list = shopService.getListShop();
		model.addAttribute("listShop", list);
		model.addAttribute("shopForm", new ShopInfo());
		return "shop";
	}

	@RequestMapping(value = "/addshop")
	public String addShop(Model model) {
		ShopInfo shopInfo = new ShopInfo();
		model.addAttribute("shopForm", shopInfo);
		return "addshop";
	}

	@RequestMapping(value = "/addshop", method = RequestMethod.POST)
	public String addShop(Model model, @ModelAttribute(value = "shopForm") ShopInfo shopForm, BindingResult result) {
		boolean check = true;
		if (Helpers.isEmpty(shopForm.getAddress())) {
			check = false;
			result.rejectValue("address", "address is not empty");
		}
		if (Helpers.isEmpty(shopForm.getName())) {
			check = false;
			result.rejectValue("name", "name is not empty");
		}
		if (Helpers.isEmpty(shopForm.getTel())) {
			check = false;
			result.rejectValue("tel", "tel is not e,pty");
		}
		if (!check) {
			return "addshop";
		}
		check = shopService.addShop(shopForm);
		if (check) {
			return "redirect: shop";
		}
		String msg = "error, do not add new shop";
		model.addAttribute("error", msg);
		return "addshop";
	}

	@RequestMapping(value = "/editshop")
	public String editShop(Model model, ShopInfo shopInfo) {
		ShopInfo shopForm = shopService.findShopById(shopInfo.getId());
		model.addAttribute("shopForm", shopForm);
		return "editshop";
	}

	@RequestMapping(value = "/editshop", method = RequestMethod.POST)
	public String editShop(Model model, @ModelAttribute(value = "shopForm") ShopInfo shopForm, BindingResult result) {
		boolean check = true;
		if (Helpers.isEmpty(shopForm.getAddress())) {
			check = false;
			result.rejectValue("address", "address is not empty");
		}
		if (Helpers.isEmpty(shopForm.getName())) {
			check = false;
			result.rejectValue("name", "name is not empty");
		}
		if (Helpers.isEmpty(shopForm.getTel())) {
			check = false;
			result.rejectValue("tel", "tel is not e,pty");
		}
		if (!check) {
			return "editshop";
		}
		check = shopService.addShop(shopForm);
		if (check) {
			return "redirect: shop";
		}
		String msg = "error, do not edit shop, please check information again!";
		model.addAttribute("error", msg);
		return "editshop";
	}
	
	@RequestMapping(value="/deleteshop")
	public String deleteShop(Model model, ShopInfo shopForm){
		boolean check = shopService.deleteShop(shopForm);
		if(check){
			return "redirect: shop";
		}
		String msg = "error, do not delete shop. please check information again";
		model.addAttribute("error", msg);
		return "shop";
	}
	
	@RequestMapping(value="/searchshop")
	public String searchShop(Model model, @ModelAttribute(value="shopForm") ShopInfo shopForm){
		List<ShopInfo> listShopInfo = new ArrayList<ShopInfo>();
		listShopInfo = shopService.searchShop(shopForm);
		model.addAttribute("listShop", listShopInfo);
		return "shop";
	}
	
}
