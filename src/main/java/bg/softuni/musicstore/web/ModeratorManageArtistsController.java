package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.binding.AlbumBindingModel;
import bg.softuni.musicstore.model.view.AlbumViewModel;
import bg.softuni.musicstore.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/artists")
public class ModeratorManageArtistsController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public ModeratorManageArtistsController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public AlbumBindingModel albumBindingModel() {
        return new AlbumBindingModel();
    }

    @GetMapping("/manage")
    public String manageArtists() {

        return "moderator-manage-artists";
    }

    @GetMapping("/manage/albums/api")
    public String manageAlbums() {

        return "moderator-manage-albums";
    }

    @GetMapping("/manage/albums/{id}/edit")
    public String editAlbum(@PathVariable Long id,
                            Model model) {

        AlbumViewModel albumViewModel = albumService.findAlbumById(id);

        AlbumBindingModel albumBindingModel = modelMapper.map(albumViewModel, AlbumBindingModel.class);

        model.addAttribute("albumBindingModel", albumBindingModel);

        return "moderator-manage-albums-edit";
    }
}