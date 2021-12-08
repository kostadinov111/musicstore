package bg.softuni.musicstore.service;

import bg.softuni.musicstore.model.dto.AlbumsDTO;
import bg.softuni.musicstore.model.view.AlbumViewModel;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<AlbumsDTO> getAllAlbums();

    Optional<AlbumsDTO> getAlbumById(Long id);

    void deleteAlbumById(Long id);

    Long createAlbum(AlbumsDTO albumsDTO);

    AlbumViewModel findAlbumById(Long id);

    Long updateAlbum(AlbumsDTO albumsDTO);
}
