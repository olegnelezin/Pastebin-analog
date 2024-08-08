package org.example.service.impl;

import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.MinioException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import org.example.configuration.properties.MinioProperties;
import org.example.service.MinioService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

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
        var bucketExistsArgs = BucketExistsArgs.builder()
                .bucket(bucket)
                .build();

        try {
            if (minioClient.bucketExists(bucketExistsArgs)) {
                return;
            }
        } catch (Exception e) {
            // throw bucket exception
        }

        var makeBucketArgs = MakeBucketArgs.builder()
                .bucket(bucket)
                .build();

        try {
            minioClient.makeBucket(makeBucketArgs);
        } catch (Exception e) {
            // throw bucket exception
        }
    }

    @Override
    public String uploadText(String text) {
        var minioUrl = text.hashCode() + String.valueOf(LocalDateTime.now());
        var putObjectArgs = PutObjectArgs.builder()
                .bucket(minioProperties.getBucket())
                .contentType("text/plain")
                .object(minioUrl)
                .stream(new ByteArrayInputStream(text.getBytes()), text.length(), -1 )
                .build();

        try {
            minioClient.putObject(putObjectArgs);
        } catch (Exception e) {
            // throw exception
        }
        return minioUrl;
    }

    @Override
    public String getText(String minioUrl) {
        var getObjectArgs = GetObjectArgs.builder()
                .bucket(minioProperties.getBucket())
                .object(minioUrl)
                .build();
        try {
            var inputStream = minioClient.getObject(getObjectArgs);
            return new String(inputStream.readAllBytes());
        } catch (Exception e) {
            // throw exception
            throw new RuntimeException(e.getMessage());
        }
     }
}