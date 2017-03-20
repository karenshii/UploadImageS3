package com.framgia.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service implements IS3Service {
	private static final String URL_PREFIX = "https://s3-us-west-2.amazonaws.com/";

	@Autowired
	private AmazonS3 s3client;

	@Value("${aws_namecard_bucket}")
	private String nameCardBucket;

	public void s3UploadCommand(String uploadFile, String filename) {

		String fileNameInS3 = filename;

		s3client.putObject(new PutObjectRequest(nameCardBucket, fileNameInS3, new File(uploadFile))
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}

	public String getS3Url() {
		return URL_PREFIX + nameCardBucket + "/";
	}

}
