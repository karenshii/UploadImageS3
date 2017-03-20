package com.framgia.service;

public interface IS3Service {

	public void s3UploadCommand(String uploadFile, String fileName);
	public String getS3Url();
}
