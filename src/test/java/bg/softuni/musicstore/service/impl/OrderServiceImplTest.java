package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.entity.OrderEntity;
import bg.softuni.musicstore.model.entity.UserEntity;
import bg.softuni.musicstore.model.enums.GenreEnums;
import bg.softuni.musicstore.repository.OrderRepository;
import bg.softuni.musicstore.service.AlbumService;
import bg.softuni.musicstore.service.UserService;
import bg.softuni.musicstore.web.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    private OrderEntity testOrder;
    private AlbumEntity testAlbum;
    private UserEntity testUser;

    OrderServiceImpl serviceToTest;
    ModelMapper testModelMapper;
    UserService testUserService;
    AlbumService testAlbumService;

    @Mock
    OrderRepository mockOrderRepository;

    @BeforeEach
    void setUp() {

        serviceToTest = new OrderServiceImpl(mockOrderRepository, testModelMapper, testUserService ,testAlbumService);

        testAlbum = new AlbumEntity();
        testAlbum.setId(1L);
        testAlbum.setName("TestAlbumName");
        testAlbum.setReleased(LocalDate.of(1970,3,1));
        testAlbum.setPrice(BigDecimal.valueOf(20.50));
        testAlbum.setGenre(GenreEnums.ROCK);

        testUser = new UserEntity();
        testUser.setId(1L);
        testUser.setUsername("testUsername");

        testOrder = new OrderEntity();
        testOrder.setId(1L);
        testOrder.setName("testOrderName");
        testOrder.setDescription("testOrderDescription");
        testOrder.setPrice(BigDecimal.valueOf(20.0));
        testOrder.setOrderTime(LocalDateTime.now());
        testOrder.setAlbum(testAlbum);

    }

    @Test
    void testFindOrderById() {

        Mockito.when(mockOrderRepository.findById(testOrder.getId()))
                .thenReturn(Optional.of(testOrder));

        var actual =
                mockOrderRepository.findById(testOrder.getId());

        Assertions.assertEquals(actual.get().getId(), testOrder.getId());
    }

}