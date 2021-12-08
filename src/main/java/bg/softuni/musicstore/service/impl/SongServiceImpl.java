package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.SongEntity;
import bg.softuni.musicstore.model.service.SongAddServiceModel;
import bg.softuni.musicstore.model.view.SongViewModel;
import bg.softuni.musicstore.repository.SongRepository;
import bg.softuni.musicstore.service.SongService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ModelMapper modelMapper;

    public SongServiceImpl(SongRepository songRepository, ModelMapper modelMapper) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SongViewModel> findAllSongs() {

        return songRepository
                .findAll()
                .stream()
                .map(songEntity -> modelMapper.map(songEntity, SongViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public SongAddServiceModel addSong(SongAddServiceModel songAddServiceModel) {

        SongEntity songEntity = modelMapper.map(songAddServiceModel, SongEntity.class);

        return modelMapper.map(songRepository.save(songEntity), SongAddServiceModel.class);
    }

    @Override
    public SongViewModel findSongById(Long id) {

        Optional<SongEntity> songEntity = songRepository.findById(id);

        if (songEntity.isEmpty()) {
            throw new UsernameNotFoundException("Song with ID " + id + " not found.");
        }

        return modelMapper.map(songEntity.get(), SongViewModel.class);
    }
}
