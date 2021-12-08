package bg.softuni.musicstore.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class PictureEntity extends BaseEntity {

    private String title;
    private String url;
    private String publicId;
    private MusicianEntity musician;

    public PictureEntity() {
    }

    public String getTitle() {
        return title;
    }

    public PictureEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureEntity setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    @ManyToOne
    public MusicianEntity getMusician() {
        return musician;
    }

    public PictureEntity setMusician(MusicianEntity musician) {
        this.musician = musician;
        return this;
    }
}