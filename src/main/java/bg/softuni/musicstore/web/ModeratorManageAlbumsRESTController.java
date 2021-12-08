package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.binding.AlbumBindingModel;
import bg.softuni.musicstore.model.dto.AlbumsDTO;
import bg.softuni.musicstore.model.view.AlbumViewModel;
import bg.softuni.musicstore.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists/manage")
public class ModeratorManageAlbumsRESTController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public ModeratorManageAlbumsRESTController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<AlbumsDTO>> getAllAlbums() {

        List<AlbumsDTO> albumsDTOList =
                albumService.getAllAlbums();

        return ResponseEntity.ok(albumsDTOList);
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<AlbumsDTO> getAlbumById(@PathVariable Long id) {

        Optional<AlbumsDTO> albumsDTO =
                albumService
                        .getAlbumById(id);

        if (albumsDTO.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(albumsDTO.get());
    }

    @GetMapping("/albums/{id}/edit/error")
    public String updateAlbumError() {

        return "moderator-manage-albums-edit";
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<AlbumsDTO> deleteAlbum(@PathVariable Long id) {

        albumService
                .deleteAlbumById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping("/albums")
    public ResponseEntity<AlbumsDTO> createAlbum(@RequestBody AlbumsDTO albumsDTO,
                                                 UriComponentsBuilder uriComponentsBuilder) {

        Long albumId = albumService.createAlbum(albumsDTO);

        URI uri = uriComponentsBuilder
                .path("/albums/{id}")
                .buildAndExpand(albumId)
                .toUri();

        return ResponseEntity
                .created(uri)
                .build();
    }

//    @PatchMapping("/albums/{id}/edit")
    @PostMapping("albums/{id}/edit")
    public ResponseEntity<AlbumsDTO> updateAlbum(@RequestBody AlbumBindingModel albumBindingModel,
                                                 @PathVariable Long id,
                                                 UriComponentsBuilder uriComponentsBuilder) {

        AlbumsDTO albumsDTO = modelMapper.map(albumBindingModel, AlbumsDTO.class);

//        AlbumViewModel albumViewModel = albumService.findAlbumById(id);

//        AlbumsDTO albumsDTO = modelMapper.map(albumViewModel, AlbumsDTO.class);
//        Long albumId = albumService.updateAlbum(albumsDTO);
        Long albumId = albumService.updateAlbum(albumsDTO);

        URI uri = uriComponentsBuilder
                .path(String.format("/albums/%d", id))
                .buildAndExpand(albumId)
                .toUri();

        return ResponseEntity
                .created(uri)
                .build();
    }
}
