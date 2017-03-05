package com.framgia.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.service.IOrderDetailService;
import com.framgia.service.IProductService;


@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/product/{shopId}", method = RequestMethod.GET)
	public String getProductByShopId(@PathVariable(value = "shopId") Long shopId, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("productList", productService.findByShopId(shopId));
		return "product-lists";
	}
}
