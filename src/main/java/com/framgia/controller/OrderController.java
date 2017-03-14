package com.framgia.controller;

import java.util.ArrayList;
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
import com.framgia.model.Product;
import com.framgia.service.IOderService;
import com.framgia.service.IOrderDetailService;
import com.framgia.service.IProductService;

@Controller
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private IOrderDetailService orderDetailService;

	@Autowired
	private IOderService orderService;

	@Autowired
	private IProductService productService;

	public List<ProductInfo> productInfoList;

	@RequestMapping(value = "/order-detail-lists/{shopId}", method = RequestMethod.GET)
	public String getOrderDetailList(@PathVariable(value = "shopId") Long shopId, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("listOrderDetails", orderDetailService.findByShopId(shopId));
		return "order-detail-lists";
	}

	@RequestMapping(value = "/save-order/{userId}", method = RequestMethod.POST)
	public String saveOrder(@PathVariable(value = "userId") Long userId, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		if (productInfoList != null) {
				long orderNum = orderService.saveOrder(productInfoList, userId);
				orderDetailService.saveOrderDetail(productInfoList, orderNum);
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
