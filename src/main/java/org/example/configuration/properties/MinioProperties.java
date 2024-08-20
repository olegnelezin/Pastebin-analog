package org.example.configuration.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(value = "minio")
@Configuration
public class MinioProperties {

    private String accessKey;

    private String secretKey;

    private String url;

    private String bucket;
}