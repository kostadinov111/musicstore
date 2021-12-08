package bg.softuni.musicstore.service;

import bg.softuni.musicstore.model.entity.EventEntity;

public interface EventService {
    EventEntity findEventByMusicianId(Long id);
}
