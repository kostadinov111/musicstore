package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.entity.OrderEntity;
import bg.softuni.musicstore.model.entity.UserEntity;
import bg.softuni.musicstore.model.view.AlbumViewModel;
import bg.softuni.musicstore.repository.OrderRepository;
import bg.softuni.musicstore.service.AlbumService;
import bg.softuni.musicstore.service.OrderService;
import bg.softuni.musicstore.service.UserService;
import bg.softuni.musicstore.web.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final AlbumService albumService;


    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, AlbumService albumService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.albumService = albumService;
    }

    @Override
    public void addOrder(Long albumId, String username) {

        UserEntity userEntity = userService.findByUsername(username);

        Optional<AlbumEntity> albumEntity =  albumService.findAlbumEntityById(albumId);

        if (albumEntity.isEmpty()) {
            throw new ObjectNotFoundException(albumId);
        }

        OrderEntity orderEntity = new OrderEntity();


        orderEntity
                .setPrice(albumEntity.get().getPrice())
                .setAlbum(albumEntity.get())
                .setUser(userEntity);

        orderRepository.save(orderEntity);
    }

    @Override
    public List<AlbumViewModel> findAlbumsByUsername(String username) {

        List<OrderEntity> orderEntityList = orderRepository.findAllByUserUsername(username);

        List<AlbumViewModel> albumViewModelList = new ArrayList<>();

        orderEntityList
                .forEach(orderEntity -> {
                    AlbumViewModel albumViewModel = modelMapper.map(orderEntity.getAlbum(), AlbumViewModel.class);
                    albumViewModel.setOwnerId(orderEntity.getId());
                    albumViewModelList.add(albumViewModel);
                });

        return albumViewModelList;
    }

    @Override
    public void deleteOrderEntityById(Long id) {

        orderRepository.deleteById(id);
    }

    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    @Override
    public Optional<OrderEntity> findOrderById(Long id) {

        return orderRepository.findById(id);
    }
}
