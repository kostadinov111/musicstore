package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.binding.MusicianEditBindingModel;
import bg.softuni.musicstore.model.service.MusicianUpdateServiceModel;
import bg.softuni.musicstore.model.view.MusicianViewModel;
import bg.softuni.musicstore.service.EventService;
import bg.softuni.musicstore.service.MusicianService;
import bg.softuni.musicstore.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/artists/manage")
public class ModeratorManageMusiciansController {

    private final MusicianService musicianService;
    private final EventService eventService;
    private final ModelMapper modelMapper;
    private final PictureService pictureService;

    public ModeratorManageMusiciansController(MusicianService musicianService, EventService eventService, ModelMapper modelMapper, PictureService pictureService) {
        this.musicianService = musicianService;
        this.eventService = eventService;
        this.modelMapper = modelMapper;
        this.pictureService = pictureService;
    }

    @ModelAttribute
    public MusicianEditBindingModel musicianEditBindingModel() {
        return new MusicianEditBindingModel();
    }

    @ModelAttribute
    public MusicianViewModel musicianViewModel() {
        return new MusicianViewModel();
    }

    @GetMapping("/musicians")
    public String getMusicians(Model model) {

        List<MusicianViewModel> musicianViewModelList =
                musicianService
                        .findAll();

        model.addAttribute("musiciansList", musicianViewModelList);

        return "moderator-manage-musicians";
    }

    @GetMapping("/musicians/details/{id}/edit")
    public String editMusicians(@PathVariable Long id,
                                Model model
    ) {

        MusicianViewModel musicianEditModel = musicianService
                .findMusicianByEntityGraphId(id);

        model.addAttribute("musicianEditModel", musicianEditModel);

        MusicianEditBindingModel musicianEditBindingModel = modelMapper.map(musicianEditModel, MusicianEditBindingModel.class);

        model.addAttribute("musicianEditBindingModel", musicianEditBindingModel);

        return "moderator-manage-musicians-edit";
    }

    @GetMapping("/musicians/details/{id}/edit/errors")
    public String updateMusiciansErrors(@PathVariable Long id
    ) {

        return "moderator-manage-musicians-edit";
    }

    @PatchMapping("/musicians/details/{id}/edit")
    public String updateMusician(@PathVariable Long id,
                                 @Valid MusicianEditBindingModel musicianEditBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes
    ) {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("musicianEditBindingModel", musicianEditBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.musicianEditBindingModel", bindingResult);

            return "redirect:/artists/manage/musicians/details/" + id + "/edit/errors";
        }

        MusicianUpdateServiceModel musicianUpdateServiceModel = modelMapper.map(musicianEditBindingModel, MusicianUpdateServiceModel.class);

        musicianUpdateServiceModel.setId(id);

        musicianService.updateMusician(musicianUpdateServiceModel);

        return "redirect:/artists/manage/musicians/";

    }

    @GetMapping("/musicians/{id}/details/")
    public String showMusicianDetails(@PathVariable Long id,
                                      Model model
    ) {

//        Testing error handling page
//        if (true) {
//            throw new ObjectNotFoundException(id);
//        }

        MusicianViewModel musicianViewModel = musicianService
                .findMusicianByEntityGraphId(id);

        musicianViewModel.setEvent(eventService.findEventByMusicianId(id));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String dateTimePattern = musicianViewModel.getEvent().getDateTime().format(formatter);

        var pictureViewModel =
                pictureService.findPictureByMusicianId(id);

        model.addAttribute("musicianViewModel", musicianViewModel);
        model.addAttribute("dateTimePattern", dateTimePattern);
        model.addAttribute("pictureViewModel", pictureViewModel);

        return "moderator-manage-musicians-details";
    }

    @DeleteMapping("/musicians/details/{id}/delete")
    public String deleteMusician(@PathVariable Long id) {

        musicianService
                .deleteMusicianEntityById(id);

        return "redirect:/artists/manage/musicians";
    }
}