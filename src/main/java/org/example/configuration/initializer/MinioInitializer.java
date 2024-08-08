package org.example.configuration.initializer;

import jakarta.annotation.PostConstruct;
import org.example.configuration.properties.MinioProperties;
import org.example.service.MinioService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioInitializer {

    private final MinioProperties minioProperties;

    private final MinioService minioService;

    public MinioInitializer(MinioProperties minioProperties, MinioService minioService) {
        this.minioProperties = minioProperties;
        this.minioService = minioService;
    }

    @PostConstruct
    public void init() {
        initializeBucket();
    }

    private void initializeBucket() {
        minioService.createBucket(minioProperties.getBucket());
    }
}
