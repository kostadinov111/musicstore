package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.SongEntity;
import bg.softuni.musicstore.model.enums.GenreEnums;
import bg.softuni.musicstore.repository.SongRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SongServiceImplTest {

    private SongEntity testSong;

    SongServiceImpl serviceToTest;
    ModelMapper modelMapper;

    @Mock
    private SongRepository mockSongRepository;

    @BeforeEach
    void setUp() {

        serviceToTest = new SongServiceImpl(mockSongRepository, modelMapper);

        testSong = new SongEntity();
        testSong.setId(1L);
        testSong.setName("TestSongName");
        testSong.setDuration(240);
        testSong.setGenre(GenreEnums.ROCK);
    }

    @Test
    void testSongFindById() {

        Mockito.when(mockSongRepository.findById(testSong.getId()))
                .thenReturn(Optional.of(testSong));

        var actual =
                mockSongRepository.findById(testSong.getId());

        Assertions.assertEquals(actual.get().getName(), testSong.getName());

    }

    @Test
    void testSongNotFound() {

        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.findSongById(0L));

    }
}