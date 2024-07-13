package org.example.configuration;

import io.minio.MinioClient;
import org.example.configuration.properties.MinioProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(MinioProperties.class)
@Configuration
public class MinioConfiguration {

    @Bean
    public MinioClient minioClient(MinioProperties minioProperties) {
        return new MinioClient.Builder()
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .endpoint(minioProperties.getUrl())
                .build();
    }
}