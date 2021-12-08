package bg.softuni.musicstore.model.binding;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.enums.GenreEnums;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class SongAddBindingModel {

    private Long id;
    private String name;
    private Integer duration;
    private GenreEnums genre;
    private AlbumEntity album;

    public SongAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public SongAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    @NotNull
    @Size(min = 1, max = 50, message = "Title must be between 1 and 50 characters.")
    public String getName() {
        return name;
    }

    public SongAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    @Positive(message = "Duration must be positive number.")
    public Integer getDuration() {
        return duration;
    }

    public SongAddBindingModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public GenreEnums getGenre() {
        return genre;
    }

    public SongAddBindingModel setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public SongAddBindingModel setAlbum(AlbumEntity album) {
        this.album = album;
        return this;
    }
}
