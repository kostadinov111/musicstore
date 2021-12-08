package bg.softuni.musicstore.service;

import bg.softuni.musicstore.model.entity.MusicianEntity;
import bg.softuni.musicstore.model.service.MusicianUpdateServiceModel;
import bg.softuni.musicstore.model.view.MusicianViewModel;

import java.util.List;
import java.util.Optional;

public interface MusicianService {
    List<MusicianViewModel> findAll();

    MusicianViewModel findMusicianByEntityGraphId(Long id);

    void deleteMusicianEntityById(Long id);

    void updateMusician(MusicianUpdateServiceModel musicianUpdateServiceModel);

    Optional<MusicianEntity> findMusicianEntityByName(String name);
}
