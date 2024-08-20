package org.example.service.impl;

import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.AllArgsConstructor;
import org.example.configuration.properties.MinioProperties;
import org.example.service.MinioService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;

import static org.example.exception.MinioException.Code.CREATE_BUCKET;
import static org.example.exception.MinioException.Code.GET_TEXT;
import static org.example.exception.MinioException.Code.UPLOAD_TEXT;

@AllArgsConstructor
@Service
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;

    private final MinioProperties minioProperties;

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
            throw CREATE_BUCKET.get("Something went wrong with creating bucket");
        }

        var makeBucketArgs = MakeBucketArgs.builder()
                .bucket(bucket)
                .build();

        try {
            minioClient.makeBucket(makeBucketArgs);
        } catch (Exception e) {
            throw CREATE_BUCKET.get("Something went wrong with creating bucket");
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
            throw UPLOAD_TEXT.get("Something went wrong with uploading data in bucket");
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
            throw GET_TEXT.get("Something went wrong with getting data from minio");
        }
     }
}
