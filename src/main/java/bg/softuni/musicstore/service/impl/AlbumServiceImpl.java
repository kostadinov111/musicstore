package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.dto.AlbumsDTO;
import bg.softuni.musicstore.model.dto.MusicianDTO;
import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.entity.MusicianEntity;
import bg.softuni.musicstore.model.view.AlbumViewModel;
import bg.softuni.musicstore.repository.AlbumRepository;
import bg.softuni.musicstore.service.AlbumService;
import bg.softuni.musicstore.service.MusicianService;
import bg.softuni.musicstore.web.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final MusicianService musicianService;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, MusicianService musicianService, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.musicianService = musicianService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AlbumsDTO> getAllAlbums() {

        return albumRepository
                .findAll()
                .stream()
                .map(albumEntity -> {
                    AlbumsDTO albumsDTO = modelMapper.map(albumEntity, AlbumsDTO.class);
                    MusicianDTO musicianDTO = modelMapper.map(albumEntity.getMusician(), MusicianDTO.class);

                    albumsDTO.setMusician(musicianDTO);

                    return albumsDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlbumsDTO> getAlbumById(Long id) {

        return albumRepository
                .findById(id)
                .map(albumEntity -> modelMapper.map(albumEntity, AlbumsDTO.class));
    }

    @Override
    public void deleteAlbumById(Long id) {

        albumRepository
                .deleteById(id);
    }

    @Override
    public Long createAlbum(AlbumsDTO albumsDTO) {

        MusicianEntity musicianEntity = musicianService
                .findMusicianEntityByName(albumsDTO.getMusician().getName())
                .orElseGet(() -> new MusicianEntity()
                        .setName(albumsDTO.getMusician().getName())
                        .setCountry(albumsDTO.getMusician().getCountry()));

        AlbumEntity albumEntity = new AlbumEntity()
                .setMusician(musicianEntity)
                .setName(albumsDTO.getName())
                .setPrice(albumsDTO.getPrice())
                .setReleased(albumsDTO.getReleased())
                .setGenre(albumsDTO.getGenre());

        return albumRepository.save(albumEntity).getId();
    }

    @Override
    public AlbumViewModel findAlbumById(Long id) {

        Optional<AlbumEntity> albumEntity = albumRepository.findById(id);

        if (albumEntity.isEmpty()) {
            throw new ObjectNotFoundException(id);
        }

        return modelMapper.map(albumEntity.get(), AlbumViewModel.class);
    }

    @Override
    public Long updateAlbum(AlbumsDTO albumsDTO) {

        Optional<AlbumEntity> albumEntity = albumRepository.findById(albumsDTO.getId());

        if (albumEntity.isEmpty()) {
            throw new ObjectNotFoundException(albumsDTO.getId());
        }

        albumEntity.get()
                .setName(albumsDTO.getName())
                .setReleased(albumsDTO.getReleased())
                .setPrice(albumsDTO.getPrice())
                .setGenre(albumsDTO.getGenre());

        albumRepository.save(albumEntity.get());

        return albumEntity.get().getId();
    }

    @Override
    public List<AlbumViewModel> findAll() {

        return albumRepository
                .findAll()
                .stream()
                .map(albumEntity -> modelMapper.map(albumEntity, AlbumViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlbumEntity> findAlbumEntityById(Long albumId) {

        return albumRepository.findById(albumId);
    }


}
