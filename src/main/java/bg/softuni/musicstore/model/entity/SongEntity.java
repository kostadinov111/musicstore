package bg.softuni.musicstore.model.entity;

import bg.softuni.musicstore.model.enums.GenreEnums;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "songs")
public class SongEntity extends BaseEntity {

    private String name;
    private Integer duration;
    private GenreEnums genre;
    private AlbumEntity album;

    public SongEntity() {
    }

    @Column(nullable = false)
    @Size(max = 50)
    public String getName() {
        return name;
    }

    public SongEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    @Positive
    public Integer getDuration() {
        return duration;
    }

    public SongEntity setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public GenreEnums getGenre() {
        return genre;
    }

    public SongEntity setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }

    @ManyToOne
    public AlbumEntity getAlbum() {
        return album;
    }

    public SongEntity setAlbum(AlbumEntity album) {
        this.album = album;
        return this;
    }
}