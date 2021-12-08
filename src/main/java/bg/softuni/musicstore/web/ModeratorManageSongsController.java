package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.binding.SongAddBindingModel;
import bg.softuni.musicstore.model.service.SongAddServiceModel;
import bg.softuni.musicstore.model.view.SongViewModel;
import bg.softuni.musicstore.service.SongService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/artists/manage")
public class ModeratorManageSongsController {

    private final SongService songService;
    private final ModelMapper modelMapper;

    public ModeratorManageSongsController(SongService songService, ModelMapper modelMapper) {
        this.songService = songService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public SongViewModel songViewModel() {
        return new SongViewModel();
    }

    @ModelAttribute
    public SongAddBindingModel songAddBindingModel() {
        return new SongAddBindingModel();
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {

        List<SongViewModel> songViewModelList = songService.findAllSongs();

        model.addAttribute("songViewModelList", songViewModelList);

        return "moderator-manage-songs";
    }

    @GetMapping("/songs/add/errors")
    public String addSongErrors() {

        return "moderator-manage-songs-add";
    }

    @GetMapping("/songs/{id}/edit")
    public String editSong(@PathVariable Long id,
                                Model model
    ) {

        SongViewModel songViewModel = songService
                .findSongById(id);

        model.addAttribute("songViewModel", songViewModel);

        SongAddBindingModel songAddBindingModel = modelMapper.map(songViewModel, SongAddBindingModel.class);

        model.addAttribute("songAddBindingModel", songAddBindingModel);

        return "moderator-manage-songs-edit";
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView handleException(ObjectNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("song-not-found");
        modelAndView.addObject("objectId", e.getObjectId());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);

        return modelAndView;
    }

    @PostMapping("/songs/add")
    public String addSong(@Valid SongAddBindingModel songAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("songAddBindingModel", songAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.songAddBindingModel", bindingResult);

            return "redirect:/artists/manage/songs/add/errors";
        }

        SongAddServiceModel songAddServiceModel = modelMapper.map(songAddBindingModel, SongAddServiceModel.class);

        songService.addSong(songAddServiceModel);

        return "redirect:/artists/manage/songs";
    }

    @PatchMapping("/songs/{id}/edit")
    public String updateSong(@PathVariable Long id) {

//        SongAddServiceModel songAddServiceModel = songService.updateSongById(id);

        return "redirect:/artists/manage/songs";
    }
}