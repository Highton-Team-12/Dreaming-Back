package com.anys34.dreaming.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.anys34.dreaming.global.config.properties.S3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {
    private final S3Properties s3Properties;
    private final AmazonS3Client amazonS3Client;

    public String uploadFile(MultipartFile file, String email) {
        UUID uuid = UUID.randomUUID();
        String filePath = createFilePath(email, uuid, file.getOriginalFilename());
        try {
            PutObjectRequest request = new PutObjectRequest(
                    s3Properties.getBucket(),
                    filePath,
                    file.getInputStream(),
                    getObjectMetadata(file)
            );
            amazonS3Client.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return amazonS3Client.getUrl(s3Properties.getBucket(), filePath).toString();
    }

    private String createFilePath(String email, UUID uuid, String fileName) {
        return String.format("dreaming/%s/%s/%s", email, uuid, fileName);
    }

    private ObjectMetadata getObjectMetadata(MultipartFile file) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());
        return objectMetadata;
    }
}
