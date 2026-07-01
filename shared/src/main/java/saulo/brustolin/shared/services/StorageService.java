package saulo.brustolin.shared.services;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@AllArgsConstructor
public class StorageService {
    
    private final S3Client s3Client;

    public void upload(String bucket, String key, InputStream inputStream, long contentLength) {
        PutObjectRequest put = PutObjectRequest.builder()
            .bucket(bucket)
            .key(key)
            .build();

        s3Client.putObject(put, RequestBody.fromInputStream(inputStream, contentLength));
    }
}
