package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.binding.AlbumBindingModel;
import bg.softuni.musicstore.model.view.AlbumViewModel;
import bg.softuni.musicstore.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/artists/manage/albums")
public class ModeratorManageAlbumsController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public ModeratorManageAlbumsController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String manageAlbums(Model model) {

        List<AlbumViewModel> albumViewModelList = albumService.findAll();

        model.addAttribute("albumViewModelList", albumViewModelList);

        return "moderator-manage-albums";
    }

    @GetMapping("/{id}/edit")
    public String editAlbum(@PathVariable Long id,
                            Model model) {

        AlbumViewModel albumViewModel = albumService.findAlbumById(id);

        AlbumBindingModel albumBindingModel = modelMapper.map(albumViewModel, AlbumBindingModel.class);

        model.addAttribute("albumBindingModel", albumBindingModel);

        return "moderator-manage-albums-edit";
    }

    @PatchMapping("/{id}/edit")
    public String updateAlbum(@PathVariable Long id) {

        return "redirect:/artists/manage/albums";
    }

    @DeleteMapping("{id}/delete")
    public String deleteAlbum(@PathVariable Long id) {

        albumService.deleteAlbumById(id);

        return "redirect:/artists/manage/albums";
    }
}
