package bg.softuni.musicstore.service;

import bg.softuni.musicstore.model.entity.PictureEntity;
import bg.softuni.musicstore.model.view.PictureOfMusicianViewModel;
import bg.softuni.musicstore.model.view.PictureViewModel;

import java.util.List;

public interface PictureService {
    void savePicture(PictureEntity picture);

    List<PictureViewModel> findAll();

    void deleteAllByPublicId(String publicId);

    PictureViewModel findPictureByMusicianId(Long musicianId);

    void detachFromMusician(Long musicianId);

    List<PictureOfMusicianViewModel> findAllPictureOfMusicians();
}
