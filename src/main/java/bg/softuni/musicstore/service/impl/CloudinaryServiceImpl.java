package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.service.CloudinaryImage;
import bg.softuni.musicstore.service.CloudinaryService;
import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private static final String TEMP_FILE = "temp-file";
    private static final String URL = "url";
    private static final String PUBLIC_ID = "public_id";

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public CloudinaryImage upload(MultipartFile multipartFile) throws IOException {

        File tempFile = File.createTempFile(TEMP_FILE, multipartFile.getOriginalFilename());
        multipartFile.transferTo(tempFile);

        try {
            @SuppressWarnings("unchecked")
            Map<String, String> uploadResult = cloudinary
                    .uploader()
                    .upload(tempFile, Map.of());

            String url = uploadResult.getOrDefault(URL, "https://cdn.pixabay.com/photo/2015/03/25/13/04/page-not-found-688965_960_720.png");
            String publicId = uploadResult.getOrDefault(PUBLIC_ID, "");

            return new CloudinaryImage().setUrl(url).setPublicId(publicId);
        } finally {
            tempFile.delete();
        }

    }

    @Override
    public Boolean delete(String publicId) {

        try {
            this.cloudinary
                    .uploader()
                    .destroy(publicId, Map.of());
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
