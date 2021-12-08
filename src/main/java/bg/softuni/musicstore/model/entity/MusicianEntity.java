package bg.softuni.musicstore.model.entity;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = "musician-albums",
        attributeNodes = {
                @NamedAttributeNode("albums")
        }
)
@Entity
@Table(name = "musicians")
public class MusicianEntity extends BaseEntity {

    private String name;
    private String history;
    private String country;
    private List<AlbumEntity> albums = new ArrayList<>();
    private EventEntity event;
    //private List<PictureEntity> pictures;

    public MusicianEntity() {
    }

    @Column(nullable = false)
    @Size(max = 50)
    public String getName() {
        return name;
    }

    public MusicianEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "history", columnDefinition = "LONGTEXT")
    public String getHistory() {
        return history;
    }

    public MusicianEntity setHistory(String history) {
        this.history = history;
        return this;
    }

    @Column(nullable = false)
    @Size(max = 100)
    public String getCountry() {
        return country;
    }

    public MusicianEntity setCountry(String country) {
        this.country = country;
        return this;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "musician")
    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public MusicianEntity setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
        return this;
    }

    @ManyToOne
    public EventEntity getEvent() {
        return event;
    }

    public MusicianEntity setEvent(EventEntity event) {
        this.event = event;
        return this;
    }

//    @OneToMany
//    public List<PictureEntity> getPictures() {
//        return pictures;
//    }
//
//    public MusicianEntity setPictures(List<PictureEntity> pictures) {
//        this.pictures = pictures;
//        return this;
//    }
}