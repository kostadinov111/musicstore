package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.binding.UserRegisterBindingModel;
import bg.softuni.musicstore.model.service.UserRegisterServiceModel;
import bg.softuni.musicstore.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("userModel")
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel userModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        // TODO check if username is free
        Boolean isUsernameFree = userService.isUsernameFree(userModel.getUsername());

        if (bindingResult.hasErrors() || !userModel.getPassword().equals(userModel.getConfirmPassword()) || isUsernameFree) {

            redirectAttributes
                    .addFlashAttribute("userModel", userModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:register";
        }

        UserRegisterServiceModel userRegisterServiceModel = modelMapper.map(userModel, UserRegisterServiceModel.class);

        userService.registerAndLoginUser(userRegisterServiceModel);

        return "redirect:/";
    }

}