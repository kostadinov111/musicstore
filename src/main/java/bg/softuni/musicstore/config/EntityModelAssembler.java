package bg.softuni.musicstore.config;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import bg.softuni.musicstore.model.dto.AlbumsDTO;
import bg.softuni.musicstore.web.ModeratorManageAlbumsRESTController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class EntityModelAssembler implements RepresentationModelAssembler<AlbumsDTO, EntityModel<AlbumsDTO>> {

    @Override
    public EntityModel<AlbumsDTO> toModel(AlbumsDTO entity) {

        return EntityModel.of(entity,
                linkTo(methodOn(ModeratorManageAlbumsRESTController.class).getAlbumById(entity.getId())).withSelfRel(),
                linkTo(methodOn(ModeratorManageAlbumsRESTController.class).getAllAlbums()).withRel("albums"));
    }
}