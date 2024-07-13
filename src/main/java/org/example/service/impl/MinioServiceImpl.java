package org.example.service.impl;

import io.minio.MinioClient;
import org.example.configuration.properties.MinioProperties;
import org.example.service.MinioService;
import org.springframework.stereotype.Service;

@Service
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;

    private final MinioProperties minioProperties;

    public MinioServiceImpl(MinioClient minioClient, MinioProperties minioProperties) {
        this.minioClient = minioClient;
        this.minioProperties = minioProperties;
    }

    @Override
    public void createBucket(String bucket) {

    }
}