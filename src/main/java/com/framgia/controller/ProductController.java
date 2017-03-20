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
import com.framgia.util.S3Test;

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
	public String addProduct(@PathVariable(value = "shopId") Long shopId, Model model, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		ProductInfo obj = new ProductInfo(shopId);
		model.addAttribute("productForm", obj);
		return "add-product";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addUser(Model model, @ModelAttribute(value = "productForm") ProductInfo productForm,
			BindingResult result, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		boolean check = true;
		if (Helpers.isEmpty(productForm.getName())) {
			result.reject("name", "name is not empty");
			check = false;
		}
		if (!check) {
			return new ModelAndView("add-product");
		}

		Long productId = productService.addProduct(productForm);
		System.out.println("Product ID: ----" + productId);
		String image = new S3Test().Upload(productForm.getFileData(), productId);
		productService.editImage(productId, image);

		return new ModelAndView("redirect:/product/" + productForm.getShopId());
	}

	@RequestMapping(value = "/editProduct")
	public String editProduct(Model model, ProductInfo obj, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		if (obj != null) {
			ProductInfo productInfo = productService.findById(obj.getId());
			model.addAttribute("productForm", productInfo);
			model.addAttribute("image", productInfo.getImage());

			return "edit-product";
		} else {
			return "403";
		}

	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public String editProduct(Model model, @ModelAttribute(value = "productForm") ProductInfo productForm,
			BindingResult result, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		boolean check = true;
		if (Helpers.isEmpty(productForm.getName())) {
			result.reject("name", "name is not empty");
			check = false;
		}
		if (!check) {
			return "edit-product";
		}
		System.out.println("---------------ID" + productForm.getId());
		productForm.setImage(productService.upToS3(productForm.getFileData(), productForm.getId()));
		productService.editProduct(productForm);
		return "redirect:/product/" + productForm.getShopId();
	}

	@RequestMapping(value = { "/productImage/{productId}" }, method = RequestMethod.GET)
	public void productImage(@PathVariable(value = "productId") Long productId, Model model) {
		if (productId != null) {

		}
	}

}
