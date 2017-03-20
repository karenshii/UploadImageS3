package com.framgia.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service implements IS3Service {

	@Autowired
	private AmazonS3 s3client;
	
	@Value("${aws_namecard_bucket}")
	private String nameCardBucket;
	
	/*
	 * upload file to folder and set it to public
	 */ 
	public void uploadFile(String uploadFile, String filename) {
		
		String fileNameInS3 = filename;
		
		s3client.putObject(
			new PutObjectRequest(nameCardBucket, 
				fileNameInS3, new File(uploadFile))
		.withCannedAcl(CannedAccessControlList.PublicRead));
	}

}
