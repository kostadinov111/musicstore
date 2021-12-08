package bg.softuni.musicstore.model.view;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.entity.EventEntity;

import java.util.ArrayList;
import java.util.List;

public class MusicianViewModel {

    private Long id;
    private String name;
    private String history;
    private String country;
    private List<AlbumEntity> albums = new ArrayList<>();
    private EventEntity event;

    public MusicianViewModel() {
    }

    public Long getId() {
        return id;
    }

    public MusicianViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MusicianViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public MusicianViewModel setHistory(String history) {
        this.history = history;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public MusicianViewModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public MusicianViewModel setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
        return this;
    }

    public EventEntity getEvent() {
        return event;
    }

    public MusicianViewModel setEvent(EventEntity event) {
        this.event = event;
        return this;
    }
}