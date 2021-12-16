package bg.softuni.musicstore.util;

import bg.softuni.musicstore.service.OrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronScheduler {

    private final OrderService orderService;

    public CronScheduler(OrderService orderService) {
        this.orderService = orderService;
    }

    // <second> <minute> <hour> <day-of-month> <month> <day-of-week>
    @Scheduled(cron = "0 23 5 * * ?", zone = "Europe/Sofia")
    public void cleanOrders() {
        orderService.deleteAllOrders();
    }
}
