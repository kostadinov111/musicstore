package bg.softuni.musicstore.service;

import bg.softuni.musicstore.model.service.SongAddServiceModel;
import bg.softuni.musicstore.model.view.SongViewModel;

import java.util.List;

public interface SongService {

    List<SongViewModel> findAllSongs();

    SongAddServiceModel addSong(SongAddServiceModel songAddServiceModel);

    SongViewModel findSongById(Long id);
}
