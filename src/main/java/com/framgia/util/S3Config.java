package com.framgia.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
@ComponentScan(basePackageClasses = IS3Application.class, excludeFilters = @Filter({Controller.class, Configuration.class}))
public class S3Config {

	@Value("${aws_access_key_id}")
    private String awsId;
	
	@Value("${aws_secret_access_key}")
	private String awsKey;
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocations(new Resource[] {
				new ClassPathResource("/amazon.properties")
		});
		return ppc;
	}
	
	@Bean
	public AWSCredentials credential() {
		return new BasicAWSCredentials(awsId, awsKey);
	}
	
	@Bean
	public AmazonS3 s3client() {
		return new AmazonS3Client(credential()); 
	}
}