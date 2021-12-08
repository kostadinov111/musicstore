package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.binding.PictureBindingModel;
import bg.softuni.musicstore.model.entity.PictureEntity;
import bg.softuni.musicstore.model.view.PictureViewModel;
import bg.softuni.musicstore.service.CloudinaryImage;
import bg.softuni.musicstore.service.CloudinaryService;
import bg.softuni.musicstore.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/artists/manage")
public class PictureController {

    private final CloudinaryService cloudinaryService;
    private final PictureService pictureService;

    public PictureController(CloudinaryService cloudinaryService, PictureService pictureService) {
        this.cloudinaryService = cloudinaryService;
        this.pictureService = pictureService;
    }

    @GetMapping("/pictures")
    public String getAll(Model model) {

        List<PictureViewModel> pictureViewModelList = pictureService.findAll();

        model.addAttribute("pictureViewModelList", pictureViewModelList);

        return "moderator-manage-pictures";
    }

    @PostMapping("/pictures/add")
    public String addPicture(PictureBindingModel pictureBindingModel) throws IOException {

        var picture =
                createPictureEntity(pictureBindingModel.getPicture(), pictureBindingModel.getTitle());

        pictureService.savePicture(picture);

        return "redirect:/artists/manage/pictures";
    }

    private PictureEntity createPictureEntity(MultipartFile multipartFile, String title) throws IOException {

        final CloudinaryImage uploaded = this.cloudinaryService.upload(multipartFile);

        return new PictureEntity()
                .setTitle(title)
                .setUrl(uploaded.getUrl())
                .setPublicId(uploaded.getPublicId());

    }

    @Transactional
    @DeleteMapping("/pictures/delete")
    public String deletePicture(@RequestParam("public_id") String publicId) {

        if (cloudinaryService.delete(publicId)) {
            pictureService.deleteAllByPublicId(publicId);
        }

        return "redirect:/artists/manage/pictures";

    }
}