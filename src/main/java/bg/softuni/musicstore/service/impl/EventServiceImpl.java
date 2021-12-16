package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.binding.EventBindingModel;
import bg.softuni.musicstore.model.dto.MusicianDTO;
import bg.softuni.musicstore.model.entity.EventEntity;
import bg.softuni.musicstore.model.entity.MusicianEntity;
import bg.softuni.musicstore.model.entity.RoleEntity;
import bg.softuni.musicstore.model.entity.UserEntity;
import bg.softuni.musicstore.model.enums.RoleNameEnums;
import bg.softuni.musicstore.model.view.EventViewModel;
import bg.softuni.musicstore.repository.EventRepository;
import bg.softuni.musicstore.service.EventService;
import bg.softuni.musicstore.service.UserService;
import bg.softuni.musicstore.web.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public EventServiceImpl(EventRepository eventRepository, ModelMapper modelMapper, UserService userService) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @Override
    public EventEntity findEventByMusicianId(Long id) {

        EventEntity event = new EventEntity();

        List<EventEntity> eventEntityList = eventRepository
                .findAllByEventEntity();

        for (EventEntity eventEntity : eventEntityList) {
            for (MusicianEntity musician : eventEntity.getMusicians()) {
                if (musician.getId() == id) {
                    return eventEntity;
                }
            }
        }

        return event;
    }

    @Override
    public List<EventViewModel> findAll() {

        return eventRepository.findAllByEventEntity()
                .stream()
                .map(eventEntity -> {
                    EventViewModel eventViewModel = new EventViewModel();

                    eventViewModel
                            .setId(eventEntity.getId())
                            .setName(eventEntity.getName())
                            .setDescription(eventEntity.getDescription())
                            .setLocation(eventEntity.getLocation())
                            .setDateTime(eventEntity.getDateTime());

                    List<MusicianDTO> musicianDTOList = eventEntity
                            .getMusicians()
                            .stream()
                            .map(musicianEntity -> modelMapper.map(musicianEntity, MusicianDTO.class))
                            .collect(Collectors.toList());

                    return eventViewModel.setMusicians(musicianDTOList);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEventById(Long id) {

        // TODO remove FK first from musicians

        eventRepository.deleteById(id);
    }

    @Override
    public EventViewModel findEventById(Long id) {

        Optional<EventEntity> eventEntityOptional = eventRepository.findById(id);

        if (eventEntityOptional.isEmpty()) {
            throw new ObjectNotFoundException(id);
        }

        return modelMapper.map(eventEntityOptional.get(), EventViewModel.class);


    }

    @Override
    public EventEntity findEventEntityById(Long id) {

        Optional<EventEntity> eventEntityOptional = eventRepository.findById(id);

        if (eventEntityOptional.isEmpty()) {
            throw new ObjectNotFoundException(id);
        }

        return eventEntityOptional.get();
    }

    @Override
    public void updateEventEntity(Long id, EventBindingModel eventBindingModel) {

        Optional<EventEntity> eventEntityOptional = eventRepository.findById(id);

        if (eventEntityOptional.isEmpty()) {
            throw new ObjectNotFoundException(id);
        }

        EventEntity eventEntity = eventEntityOptional.get();

        eventEntity
                .setName(eventBindingModel.getName())
                .setDescription(eventBindingModel.getDescription())
                .setLocation(eventBindingModel.getLocation());

        eventRepository.save(eventEntity);
    }


    public Boolean isOwner(String username, Long id) {

        Optional<EventEntity> eventEntityOpt = eventRepository.findById(id);
        UserEntity userEntity = userService.findByUsername(username);

        if (eventEntityOpt.isEmpty()) {
            return false;
        } else {
            EventEntity eventEntity = eventEntityOpt.get();

            return isAdmin(userEntity) || eventEntity.getCreatedBy().equals(username);
        }


    }

    private Boolean isAdmin(UserEntity userEntity) {

        return userEntity
                .getRoles()
                .stream()
                .map(RoleEntity::getRole)
                .anyMatch(role -> role == RoleNameEnums.ADMIN);
    }
}