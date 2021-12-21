package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.binding.EventBindingModel;
import bg.softuni.musicstore.model.dto.MusicianDTO;
import bg.softuni.musicstore.model.entity.EventEntity;
import bg.softuni.musicstore.model.view.EventViewModel;
import bg.softuni.musicstore.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final ModelMapper modelMapper;

    public EventController(EventService eventService, ModelMapper modelMapper) {
        this.eventService = eventService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/show")
    public String show(Model model) {

        List<EventViewModel> eventViewModelList = eventService.findAll();

        List<String> musiciansOutput = getStringListOfMusicians(eventViewModelList);

        model.addAttribute("eventViewModelList", eventViewModelList);
        model.addAttribute("musiciansOutput", musiciansOutput);


        return "events-show";
    }

    @GetMapping("/manage")
    public String manage(Model model) {

        List<EventViewModel> eventViewModelList = eventService.findAll();

        model.addAttribute("eventViewModelList", eventViewModelList);

        return "events-manage";
    }

    @PreAuthorize("@eventServiceImpl.isOwner(#principal.name, #id)")
    @DeleteMapping("/manage/delete/{id}")
    public String del(@PathVariable Long id,
                      Principal principal
    ) {

        eventService.deleteEventById(id);

        return "redirect:/events/manage";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleEx(AccessDeniedException accessDeniedException) {

        ModelAndView modelAndView = new ModelAndView("event-access-forbidden");
        modelAndView.addObject("errorMessage", accessDeniedException.getMessage());
        modelAndView.setStatus(HttpStatus.FORBIDDEN);

        return modelAndView;
    }

    @GetMapping("/manage/edit/{id}")
    public String edit(@PathVariable Long id,
                       Model model,
                       EventBindingModel eventBindingModel
    ) {

        EventEntity eventEntity = eventService.findEventEntityById(id);

        eventBindingModel.setId(eventEntity.getId());
        eventBindingModel.setName(eventEntity.getName());
        eventBindingModel.setDescription(eventEntity.getDescription());
        eventBindingModel.setLocation(eventEntity.getLocation());

        model.addAttribute("eventBindingModel", eventBindingModel);

        return "event-edit";

    }

    @PatchMapping("/manage/edit/{id}")
    public String update(@PathVariable Long id,
                       @Valid EventBindingModel eventBindingModel,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes
    ) {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("eventBindingModel", eventBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.eventBindingModel", bindingResult);

            return "redirect:/events/manage/edit/" + id + "/errors";
        }

        eventService.updateEventEntity(id, eventBindingModel);

        return "redirect:/events/manage";

    }

    @GetMapping("/manage/edit/{id}/errors")
    public String updateEventErrors(@PathVariable Long id) {

        return "event-edit";
    }


    private List<String> getStringListOfMusicians(List<EventViewModel> eventViewModelList) {

        List<List<String>> lists = eventViewModelList
                .stream()
                .map(eventViewModel -> eventViewModel
                        .getMusicians()
                        .stream()
                        .map(MusicianDTO::getName)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<String> output = new ArrayList<>();

        for (List<String> list : lists) {
            output.add(String.join(", ", list));
        }

        return output;
    }
}
