package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.view.UserRolesManageViewModel;
import bg.softuni.musicstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserRolesController {

    private final UserService userService;

    public AdminUserRolesController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public UserRolesManageViewModel userRolesManageViewModel() {
        return new UserRolesManageViewModel();
    }

    @GetMapping("/roles")
    public String manageRoles(Model model) {

        List<UserRolesManageViewModel> userRoles = userService.findUserRoles();
        model.addAttribute("userRoles",userRoles);

        return "admin-roles";
    }

    @PostMapping("/roles/{id}/{role}/{action}")
    public String adminRemove(@PathVariable Long id, @PathVariable String role, @PathVariable String action) {

        if (action.equals("remove")) {
            userService.removeRole(id, role);
        } else if (action.equals("add")) {
            userService.addRole(id, role);
        }

        return "redirect:/admin/roles";
    }
}