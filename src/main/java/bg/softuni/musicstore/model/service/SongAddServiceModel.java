package bg.softuni.musicstore.model.service;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.enums.GenreEnums;

public class SongAddServiceModel {

    private Long id;
    private String name;
    private Integer duration;
    private GenreEnums genre;
    private AlbumEntity album;

    public SongAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public SongAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SongAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongAddServiceModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public GenreEnums getGenre() {
        return genre;
    }

    public SongAddServiceModel setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public SongAddServiceModel setAlbum(AlbumEntity album) {
        this.album = album;
        return this;
    }
}
