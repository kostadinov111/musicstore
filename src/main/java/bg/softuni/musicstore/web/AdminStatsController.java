package bg.softuni.musicstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminStatsController {

    @GetMapping("/stats")
    public String getStats() {
        return "admin-stats";
    }
}