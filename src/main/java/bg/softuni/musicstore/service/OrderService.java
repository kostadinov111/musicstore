package bg.softuni.musicstore.service;

import bg.softuni.musicstore.model.entity.OrderEntity;
import bg.softuni.musicstore.model.view.AlbumViewModel;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    void addOrder(Long albumId, String username);

    List<AlbumViewModel> findAlbumsByUsername(String username);

    void deleteOrderEntityById(Long id);

    void deleteAllOrders();

    Optional<OrderEntity> findOrderById(Long id);
}
