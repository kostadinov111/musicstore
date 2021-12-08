package bg.softuni.musicstore.model.binding;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.entity.EventEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class MusicianEditBindingModel {

    private Long id;
    private String name;
    private String history;
    private String country;
    private List<AlbumEntity> albums = new ArrayList<>();
    private EventEntity event;

    public MusicianEditBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public MusicianEditBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50, message = "Musician name must be between 1 and 50 characters.")
    public String getName() {
        return name;
    }

    public MusicianEditBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public MusicianEditBindingModel setHistory(String history) {
        this.history = history;
        return this;
    }

    @NotBlank
    @NotNull
    @Size(min = 1, max = 100, message = "Country must be between 1 and 100 characters.")
    public String getCountry() {
        return country;
    }

    public MusicianEditBindingModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public MusicianEditBindingModel setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
        return this;
    }

    public EventEntity getEvent() {
        return event;
    }

    public MusicianEditBindingModel setEvent(EventEntity event) {
        this.event = event;
        return this;
    }
}