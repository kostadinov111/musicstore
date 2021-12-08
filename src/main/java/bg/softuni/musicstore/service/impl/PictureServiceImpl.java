package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.PictureEntity;
import bg.softuni.musicstore.model.view.PictureViewModel;
import bg.softuni.musicstore.repository.PictureRepository;
import bg.softuni.musicstore.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void savePicture(PictureEntity picture) {

        pictureRepository.save(picture);
    }

    @Override
    public List<PictureViewModel> findAll() {

        return pictureRepository
                .findAll()
                .stream()
                .map(pictureEntity -> modelMapper.map(pictureEntity, PictureViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllByPublicId(String publicId) {

        pictureRepository.deleteAllByPublicId(publicId);
    }

    @Override
    public PictureViewModel findPictureByMusicianId(Long musicianId) {

        return modelMapper
                .map(pictureRepository.findPictureEntityByMusicianId(musicianId), PictureViewModel.class);
    }
}
