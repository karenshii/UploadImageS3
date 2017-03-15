package com.framgia.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framgia.bean.ProductInfo;
import com.framgia.service.IOderService;

@Controller
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private IOderService orderService;

	@RequestMapping(value = "/save-order/{userId}", method = RequestMethod.POST)
	public String saveOrder(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "productInfoList") List<ProductInfo> productInfoList, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		if (productInfoList != null) {
			orderService.saveOrder(productInfoList, userId);
			return "order-detail-lists";
		} else {
			return "redirect:/emptyCartNotify";
		}
	}

	@RequestMapping(value = "/emptyCartNotify")
	@ResponseBody
	public String emptyCartNoti(){
		return "Your cart is empty! Please select item!";
	}
	

}
