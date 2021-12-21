package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.EventEntity;
import bg.softuni.musicstore.model.entity.MusicianEntity;
import bg.softuni.musicstore.model.entity.UserEntity;
import bg.softuni.musicstore.repository.EventRepository;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    private EventEntity testEvent;
    private MusicianEntity testMusician;
    private UserEntity testUser;

    EventServiceImpl serviceToTest;
    ModelMapper testModelMapper;
    UserService testUserService;

    @Mock
    EventRepository mockEventRepository;

    @BeforeEach
    void setUp() {

        serviceToTest = new EventServiceImpl(mockEventRepository, testModelMapper, testUserService);

        testMusician = new MusicianEntity();
        testMusician.setId(1L);

        testUser = new UserEntity();
        testUser.setId(1L);
        testUser.setUsername("testUsername");

        testEvent = new EventEntity();
        testEvent.setId(1L);
        testEvent.setName("TestEventName");
        testEvent.setDescription("TestEventDescription");
        testEvent.setLocation("Sofia");
        testEvent.setDateTime(LocalDateTime.now());
        testEvent.setMusicians(List.of(testMusician));
        testEvent.setCreatedBy("moderator");
    }

    @Test
    void testFindEventById() {

        Mockito.when(mockEventRepository.findById(testEvent.getId()))
                .thenReturn(Optional.of(testEvent));

        var actual =
                mockEventRepository.findById(testEvent.getId());

        Assertions.assertEquals(actual.get().getName(), testEvent.getName());
    }

    @Test
    void testFindEventNotExist() {

        Assertions.assertThrows(
                ObjectNotFoundException.class,
                () -> serviceToTest.findEventById(0L));
    }

}