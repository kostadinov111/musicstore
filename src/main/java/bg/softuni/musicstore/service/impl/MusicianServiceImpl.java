package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.MusicianEntity;
import bg.softuni.musicstore.model.service.MusicianUpdateServiceModel;
import bg.softuni.musicstore.model.view.MusicianViewModel;
import bg.softuni.musicstore.repository.MusicianRepository;
import bg.softuni.musicstore.service.MusicianService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicianServiceImpl implements MusicianService {

    private final MusicianRepository musicianRepository;
    private final ModelMapper modelMapper;

    public MusicianServiceImpl(MusicianRepository musicianRepository, ModelMapper modelMapper) {
        this.musicianRepository = musicianRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<MusicianViewModel> findAll() {

        return musicianRepository
                .findAllByMusicianEntity()
                .stream()
                .map(musicianEntity -> modelMapper.map(musicianEntity, MusicianViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public MusicianViewModel findMusicianByEntityGraphId(Long id) {

        return modelMapper
                .map(musicianRepository.findEntityById(id), MusicianViewModel.class);
    }

    @Override
    public void deleteMusicianEntityById(Long id) {

        musicianRepository
                .deleteById(id);
    }

    @Override
    public void updateMusician(MusicianUpdateServiceModel musicianUpdateServiceModel) {

        MusicianEntity musicianEntity = musicianRepository.findEntityById(musicianUpdateServiceModel.getId());

        musicianEntity
                .setName(musicianUpdateServiceModel.getName())
                .setCountry(musicianUpdateServiceModel.getCountry())
                .setHistory(musicianUpdateServiceModel.getHistory());

        musicianRepository.save(musicianEntity);
    }

    @Override
    public Optional<MusicianEntity> findMusicianEntityByName(String name) {

        return musicianRepository
                .findMusicianEntityByName(name);
    }
}
