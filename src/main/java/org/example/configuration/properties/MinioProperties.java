package org.example.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(value = "minio")
@Configuration
public class MinioProperties {

    private String accessKey;

    private String secretKey;

    private String url;

    private String bucket;

    public MinioProperties() {
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getUrl() {
        return url;
    }

    public String getBucket() {
        return bucket;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}