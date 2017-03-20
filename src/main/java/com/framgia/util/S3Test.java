package com.framgia.util;

import java.io.File;
import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class S3Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(S3Config.class);
		ctx.refresh();

		IS3Service service = ctx.getBean(IS3Service.class);

		System.out.println(S3Test.class.getProtectionDomain().getCodeSource().getLocation());
		String uploadFile = "/home/demo/uploadTEST";
		String fileName = "gaga";

		service.uploadFile(uploadFile, fileName);

		ctx.close();
	}

	public String Upload(CommonsMultipartFile input, Long productId) {

		String url1 = S3Test.class.getProtectionDomain().getCodeSource().getLocation().toString()
				+ productId.toString();

		String url2 = url1.substring(5, url1.length());
		File newfile = new File(url2);
		try {
			input.transferTo(newfile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(S3Config.class);
		ctx.refresh();

		IS3Service service = ctx.getBean(IS3Service.class);

		System.out.println(S3Test.class.getProtectionDomain().getCodeSource().getLocation());
		String uploadFile = url2;
		String fileName = productId.toString();

		service.uploadFile(uploadFile, fileName);

		ctx.close();
		return "https://s3-us-west-2.amazonaws.com/vcbdongdahn1/" + productId.toString() + ".png";
	}

}
