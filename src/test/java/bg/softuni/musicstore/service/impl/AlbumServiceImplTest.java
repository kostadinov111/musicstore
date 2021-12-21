package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.enums.GenreEnums;
import bg.softuni.musicstore.repository.AlbumRepository;
import bg.softuni.musicstore.service.MusicianService;
import bg.softuni.musicstore.web.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlbumServiceImplTest {

    private AlbumEntity testAlbum, testAlbum2;

    AlbumServiceImpl serviceToTest;
    ModelMapper modelMapper;
    MusicianService musicianService;

    @Mock
    private AlbumRepository mockAlbumRepository;

    @BeforeEach
    void setUp() {

        serviceToTest = new AlbumServiceImpl(mockAlbumRepository, musicianService, modelMapper);

        testAlbum = new AlbumEntity();
        testAlbum.setId(1L);
        testAlbum.setName("TestAlbumName");
        testAlbum.setReleased(LocalDate.of(1970,3,1));
        testAlbum.setPrice(BigDecimal.valueOf(20.50));
        testAlbum.setGenre(GenreEnums.ROCK);

        testAlbum2 = new AlbumEntity();
        testAlbum2.setId(2L);
        testAlbum2.setName("TestAlbumName2");
        testAlbum2.setReleased(LocalDate.of(1971,4,2));
        testAlbum2.setPrice(BigDecimal.valueOf(22.50));
        testAlbum2.setGenre(GenreEnums.ELECTRONIC);
    }

    @Test
    void findAlbumById() {

        Mockito.when(mockAlbumRepository.findById(testAlbum.getId()))
                .thenReturn(Optional.of(testAlbum));

        var actual =
                mockAlbumRepository.findById(testAlbum.getId());

        Assertions.assertEquals(actual.get().getName(), testAlbum.getName());
    }

    @Test
    void notFoundAlbumById() {

        Assertions.assertThrows(
                ObjectNotFoundException.class,
                () -> serviceToTest.findAlbumById(0L));

    }

}