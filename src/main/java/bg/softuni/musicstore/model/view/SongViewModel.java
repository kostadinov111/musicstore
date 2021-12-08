package bg.softuni.musicstore.model.view;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.enums.GenreEnums;

public class SongViewModel {

    private Long id;
    private String name;
    private Integer duration;
    private GenreEnums genre;
    private AlbumEntity album;

    public SongViewModel() {
    }

    public Long getId() {
        return id;
    }

    public SongViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SongViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongViewModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public GenreEnums getGenre() {
        return genre;
    }

    public SongViewModel setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public SongViewModel setAlbum(AlbumEntity album) {
        this.album = album;
        return this;
    }
}