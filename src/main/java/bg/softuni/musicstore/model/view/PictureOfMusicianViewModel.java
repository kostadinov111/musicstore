package bg.softuni.musicstore.model.view;

import bg.softuni.musicstore.model.entity.MusicianEntity;

public class PictureOfMusicianViewModel {

    private Long id;
    private String title;
    private String url;
    private MusicianEntity musician;

    public PictureOfMusicianViewModel() {
    }

    public Long getId() {
        return id;
    }

    public PictureOfMusicianViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PictureOfMusicianViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureOfMusicianViewModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public MusicianEntity getMusician() {
        return musician;
    }

    public PictureOfMusicianViewModel setMusician(MusicianEntity musician) {
        this.musician = musician;
        return this;
    }
}
