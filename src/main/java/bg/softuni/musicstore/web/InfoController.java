package bg.softuni.musicstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoController {

    @GetMapping("/jazz")
    public String infoJazz() {
        return "info-jazz";
    }

    @GetMapping("/hard-rock")
    public String infoHardRock() {
        return "info-hard-rock";
    }

    @GetMapping("/hip-hop")
    public String infoHipHop() {
        return "info-hip-hop";
    }
}
