package org.example.service;

public interface MinioService {

    void createBucket(String bucket);

    String uploadText(String text);

    String getText(String minioUrl);
}
