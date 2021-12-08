package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.EventEntity;
import bg.softuni.musicstore.model.entity.MusicianEntity;
import bg.softuni.musicstore.repository.EventRepository;
import bg.softuni.musicstore.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
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
}