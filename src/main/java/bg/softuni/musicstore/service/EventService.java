package bg.softuni.musicstore.service;

import bg.softuni.musicstore.model.binding.EventBindingModel;
import bg.softuni.musicstore.model.entity.EventEntity;
import bg.softuni.musicstore.model.view.EventViewModel;

import java.util.List;

public interface EventService {
    EventEntity findEventByMusicianId(Long id);

    List<EventViewModel> findAll();

    void deleteEventById(Long id);

    EventViewModel findEventById(Long id);

    EventEntity findEventEntityById(Long id);

    void updateEventEntity(Long id, EventBindingModel eventBindingModel);
}
