package bg.softuni.musicstore.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {

    CloudinaryImage upload(MultipartFile multipartFile) throws IOException;
    Boolean delete(String publicId);
}
