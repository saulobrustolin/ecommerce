package saulo.brustolin.api.dtos.content;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public record UploadFileDTO(
    List<MultipartFile> files 
) {}
