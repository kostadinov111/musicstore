package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.entity.OrderEntity;
import bg.softuni.musicstore.model.view.AlbumViewModel;
import bg.softuni.musicstore.service.AlbumService;
import bg.softuni.musicstore.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final AlbumService albumService;

    public OrderController(OrderService orderService, AlbumService albumService) {
        this.orderService = orderService;
        this.albumService = albumService;
    }

    @GetMapping("/add")
    public String add(Model model,
                      Principal principal
    ) {

        List<AlbumViewModel> albumViewModelList = albumService.findAll();

        String username = principal.getName();

        List<AlbumViewModel> albumOrderedViewModelList = orderService.findAlbumsByUsername(username);

        BigDecimal total = getTotalSumOfOrderedAlbums(albumOrderedViewModelList);

        model.addAttribute("albumViewModelList", albumViewModelList);
        model.addAttribute("albumOrderedViewModelList", albumOrderedViewModelList);
        model.addAttribute("total", total);


        return "orders-add";
    }

    @GetMapping("/show")
    public String show(Model model,
                       Principal principal
    ) {

        String username = principal.getName();

        List<AlbumViewModel> albumOrderedViewModelList = orderService.findAlbumsByUsername(username);

        BigDecimal total = getTotalSumOfOrderedAlbums(albumOrderedViewModelList);

        model.addAttribute("albumOrderedViewModelList", albumOrderedViewModelList);
        model.addAttribute("total", total);

        return "orders-show";
    }

    @PostMapping("/add/{id}")
    public String confirm(@PathVariable Long id,
                          Principal principal
    ) {

        String username = principal.getName();
        orderService.addOrder(id, username);

        return "redirect:/orders/add";
    }

    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {

        Optional<OrderEntity> orderEntityOptional = orderService.findOrderById(id);

        if (orderEntityOptional.isEmpty()) {
            throw new ObjectNotFoundException(id);
        }

        orderService.deleteOrderEntityById(id);

        return "redirect:/orders/add";
    }

    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id) {

        Optional<OrderEntity> orderEntityOptional = orderService.findOrderById(id);

        if (orderEntityOptional.isEmpty()) {
            throw new ObjectNotFoundException(id);
        }

        orderService.deleteOrderEntityById(id);

        return "redirect:/orders/show";
    }

    private BigDecimal getTotalSumOfOrderedAlbums(List<AlbumViewModel> albumOrderedViewModelList) {

        BigDecimal sum = BigDecimal.ZERO;

        for (AlbumViewModel albumViewModel : albumOrderedViewModelList) {
            sum = sum.add(albumViewModel.getPrice());
        }

        return sum;
    }
}