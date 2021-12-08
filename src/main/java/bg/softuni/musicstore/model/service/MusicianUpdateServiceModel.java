package bg.softuni.musicstore.model.service;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.entity.EventEntity;

import java.util.ArrayList;
import java.util.List;

public class MusicianUpdateServiceModel {

    private Long id;
    private String name;
    private String history;
    private String country;
    private List<AlbumEntity> albums = new ArrayList<>();
    private EventEntity event;

    public MusicianUpdateServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public MusicianUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MusicianUpdateServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public MusicianUpdateServiceModel setHistory(String history) {
        this.history = history;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public MusicianUpdateServiceModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public MusicianUpdateServiceModel setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
        return this;
    }

    public EventEntity getEvent() {
        return event;
    }

    public MusicianUpdateServiceModel setEvent(EventEntity event) {
        this.event = event;
        return this;
    }
}
