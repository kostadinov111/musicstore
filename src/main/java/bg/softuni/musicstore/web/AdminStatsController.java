package bg.softuni.musicstore.web;

import bg.softuni.musicstore.service.StatsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminStatsController {

    private final StatsService statsService;

    public AdminStatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/stats")
    public ModelAndView getStats(ModelAndView modelAndView) {

        modelAndView.addObject("stats", statsService.getStats());
        modelAndView.setViewName("admin-stats");

        return modelAndView;
    }
}