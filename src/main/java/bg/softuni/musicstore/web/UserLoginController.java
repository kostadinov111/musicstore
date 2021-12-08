package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.binding.UserLoginBindingModel;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    @ModelAttribute("userModel")
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login/error")
    public String failedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
            RedirectAttributes redirectAttributes) {

        redirectAttributes
                .addFlashAttribute("bad_credentials", true)
                .addFlashAttribute("username", username);

        return "redirect:/users/login";
    }
}