package com.framgia.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.framgia.bean.ProductInfo;
import com.framgia.model.Product;
import com.framgia.util.S3Config;

public class ProductService extends BaseService implements IProductService {

	private static final Logger logger = Logger.getLogger(OrderDetailService.class);

	public List<ProductInfo> findByShopId(long shopId) {
		try {
			List<Product> productList = productDAO.findByShopId(shopId);
			List<ProductInfo> productInfoList = new ArrayList<ProductInfo>();

			for (Product product : productList) {
				ProductInfo productInfo = new ProductInfo();
				BeanUtils.copyProperties(product, productInfo);
				productInfoList.add(productInfo);
			}
			return productInfoList;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	public Long addProduct(ProductInfo productInfo) {
		logger.debug("persisting user instance");
		try {
			Product product = new Product();
			product.setName(productInfo.getName());
			product.setDetail(productInfo.getDetail());
			product.setPrice(productInfo.getPrice());
			product.setImage(productInfo.getImage());
			Date date = new Date();
			product.setDate(date);
			product.setStatus(productInfo.getStatus());
			product.setShopId(productInfo.getShopId());
			Product result = productDAO.save(product);
			return result.getId();
		} catch (Exception e) {
			logger.error("An exception save user: " + e);
			return (long) 0;
		}
	}

	public ProductInfo findById(long id) {
		try {
			Product product = productDAO.findById(id);
			ProductInfo productInfo = new ProductInfo();
			BeanUtils.copyProperties(product, productInfo);
			return productInfo;
		} catch (Exception e) {
			logger.error("An exception when find product by id: " + e);
		}
		return null;
	}

	public boolean editProduct(ProductInfo productInfo) {
		try {
			Product product = new Product();
			BeanUtils.copyProperties(productInfo, product);
			Date date = new Date();
			product.setDate(date);
			Product result = productDAO.save(product);
			logger.debug("save successful product :" + result);
		} catch (Exception e) {
			logger.error("An exception save product: " + e);
			return false;
		}
		return true;
	}
	
	public boolean editImage(Long productId, String newImage) {
		try {
			
			Product product = productDAO.findById(productId);
			product.setImage(newImage);
			Date date = new Date();
			product.setDate(date);
			Product result = productDAO.save(product);
			logger.debug("save successful product :" + result);
		} catch (Exception e) {
			logger.error("An exception save product: " + e);
			return false;
		}
		return true;
	}

	
	

	public List<ProductInfo> getAll() {
		try {
			return new ProductInfo().copy(productDAO.findAll());
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public String getImage(Long productId) {
		try {
			return productDAO.findById(productId).getImage();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public String upToS3(CommonsMultipartFile imageFile, Long productId) {
		if (imageFile == null | productId == 0)
			return null;
		try {
			Product product = productDAO.findById(productId);
			String fileName = productDAO.findById(productId).getShopId().toString() + "_" + productId +".jpg";
			String localUrl = ProductService.class.getProtectionDomain().getCodeSource().getLocation() + fileName ;
			String directUrl = localUrl.substring(5,localUrl.length());
			imageFile.transferTo(new File(directUrl));
			
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
			ctx.register(S3Config.class);
			ctx.refresh();

			IS3Service service = ctx.getBean(IS3Service.class);
			service.s3UploadCommand(directUrl, fileName);
			ctx.close();
			return service.getS3Url()+fileName;
		} catch (Exception e) {
			return null;
		}
		
	}
}
