package org.example.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(value = "minio")
@Configuration
public class MinioProperties {

    private String accessKey;

    private String secretKey;

    private String url;

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getUrl() {
        return url;
    }
}