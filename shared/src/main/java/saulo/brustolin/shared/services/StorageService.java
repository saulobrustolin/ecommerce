package saulo.brustolin.shared.services;

import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@AllArgsConstructor
public class StorageService {
    
    private final S3Client s3Client;

    public void upload(String bucket, String key, String path) {
        PutObjectRequest put = PutObjectRequest.builder()
            .bucket(bucket)
            .key(key)
            .build();

        s3Client.putObject(put, Paths.get(path));
    }
}
