package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.view.UserManageViewModel;
import bg.softuni.musicstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminManageController {

    private final UserService userService;

    public AdminManageController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public UserManageViewModel userManageViewModel() {
        return new UserManageViewModel();
    }

    @GetMapping("/manage")
    public String manageUser(Model model) {

        List<UserManageViewModel> users = userService.findAll();

        model.addAttribute("usersList", users);

        return "admin-manage";
    }

    @PostMapping("/manage/{id}/disable")
    public String manageUserConfirmDisable(@PathVariable Long id) {

        userService.disableUserById(id);

        return "redirect:/admin/manage";
    }

    @PostMapping("/manage/{id}/enable")
    public String manageUserConfirmEnable(@PathVariable Long id) {

        userService.enableUserById(id);

        return "redirect:/admin/manage";
    }

}