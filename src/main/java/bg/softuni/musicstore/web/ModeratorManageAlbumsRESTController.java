package bg.softuni.musicstore.web;

import bg.softuni.musicstore.config.EntityModelAssembler;
import bg.softuni.musicstore.model.dto.AlbumsDTO;
import bg.softuni.musicstore.model.validation.ApiError;
import bg.softuni.musicstore.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class ModeratorManageAlbumsRESTController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;
    private final EntityModelAssembler assembler;

    public ModeratorManageAlbumsRESTController(AlbumService albumService, ModelMapper modelMapper, EntityModelAssembler assembler) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
        this.assembler = assembler;
    }

    @GetMapping("/albums")
    public CollectionModel<EntityModel<AlbumsDTO>> getAllAlbums() {

        List<EntityModel<AlbumsDTO>> albumsDTOList =
                albumService
                        .getAllAlbums()
                        .stream()
                        .map(assembler::toModel)
                        .collect(Collectors.toList());

        return CollectionModel.of(albumsDTOList,
                linkTo(methodOn(ModeratorManageAlbumsRESTController.class).getAllAlbums()).withSelfRel());
    }

    @GetMapping("/albums/{id}")
    public EntityModel<AlbumsDTO> getAlbumById(@PathVariable Long id) {

        Optional<AlbumsDTO> albumsDTO =
                albumService
                        .getAlbumById(id);

        if (albumsDTO.isEmpty()) {
            throw new ObjectNotFoundException(id);
        }

        return assembler.toModel(albumsDTO.get());
    }

    @PostMapping("/albums")
    public ResponseEntity<?> createAlbum(@RequestBody AlbumsDTO albumsDTO) {

        Long albumId = albumService.createAlbum(albumsDTO);

        AlbumsDTO createdAlbumDTO = modelMapper.map(albumService.findAlbumById(albumId), AlbumsDTO.class);

        EntityModel<AlbumsDTO> entityModel = assembler.toModel(createdAlbumDTO);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PutMapping("/albums/{id}")
    ResponseEntity<?> replaceAlbum(@RequestBody AlbumsDTO newAlbumsDTO,
                                   @PathVariable Long id
    ) {
        AlbumsDTO albumsDTOtoBeReplaced = modelMapper.map(albumService.findAlbumById(id), AlbumsDTO.class);

        albumsDTOtoBeReplaced
                .setName(newAlbumsDTO.getName())
                .setReleased(newAlbumsDTO.getReleased())
                .setPrice(newAlbumsDTO.getPrice())
                .setGenre(newAlbumsDTO.getGenre())
                .setMusician(newAlbumsDTO.getMusician());

        albumService.updateAlbum(albumsDTOtoBeReplaced);

        EntityModel<AlbumsDTO> entityModel = assembler.toModel(albumsDTOtoBeReplaced);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable Long id) {

        albumService
                .deleteAlbumById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> onValidationFailure(MethodArgumentNotValidException exc) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        exc.getFieldErrors().forEach(fe -> apiError.addFieldWithError(fe.getField()));

        return ResponseEntity.badRequest().body(apiError);
    }
}
