package bg.softuni.musicstore.model.service;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.enums.GenreEnums;

public class SongUpdateServiceModel {

    private Long id;
    private String name;
    private Integer duration;
    private GenreEnums genre;
    private AlbumEntity album;

    public SongUpdateServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public SongUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SongUpdateServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongUpdateServiceModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public GenreEnums getGenre() {
        return genre;
    }

    public SongUpdateServiceModel setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public SongUpdateServiceModel setAlbum(AlbumEntity album) {
        this.album = album;
        return this;
    }
}
