package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.view.PictureOfMusicianViewModel;
import bg.softuni.musicstore.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ModeratorManageArtistsController {

    private final PictureService pictureService;

    public ModeratorManageArtistsController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping
    public String getAll(Model model) {

        List<PictureOfMusicianViewModel> pictureOfMusicianViewModelsList =
                pictureService
                        .findAllPictureOfMusicians();

        model.addAttribute("pictureOfMusicianViewModelsList", pictureOfMusicianViewModelsList);

        return "moderator-show-musicians";
    }

    @GetMapping("/manage")
    public String manageArtists() {

        return "moderator-manage-artists";
    }
}