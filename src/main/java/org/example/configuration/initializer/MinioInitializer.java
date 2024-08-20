package org.example.configuration.initializer;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.example.configuration.properties.MinioProperties;
import org.example.service.MinioService;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class MinioInitializer {

    private final MinioProperties minioProperties;

    private final MinioService minioService;

    @PostConstruct
    public void init() {
        initializeBucket();
    }

    private void initializeBucket() {
        minioService.createBucket(minioProperties.getBucket());
    }
}
