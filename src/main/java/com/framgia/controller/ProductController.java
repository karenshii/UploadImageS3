package com.framgia.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.framgia.bean.ProductInfo;
import com.framgia.service.IProductService;
import com.framgia.util.Helpers;


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
	
	@RequestMapping(value = "/addProduct/{shopId}", method = RequestMethod.GET)
	public String addProduct(@PathVariable(value = "shopId") Long shopId, Model model) {
		ProductInfo obj = new ProductInfo(shopId);
		model.addAttribute("productForm", obj);
		return "add-product";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addUser(Model model, @ModelAttribute(value = "productForm") ProductInfo productForm,
			BindingResult result) {
		boolean check = true;
		if (Helpers.isEmpty(productForm.getName())){
			result.reject("name", "name is not empty");
			check = false;
		}
		if (!check) {
			return new ModelAndView("add-product");
		}
		productService.addProduct(productForm);
		return new ModelAndView("redirect:/product/" + productForm.getShopId());
	}
}
