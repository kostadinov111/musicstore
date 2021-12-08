package bg.softuni.musicstore.model.dto;

public class MusicianDTO {

    private String name;
    private String country;

    public MusicianDTO() {
    }

    public String getName() {
        return name;
    }

    public MusicianDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public MusicianDTO setCountry(String country) {
        this.country = country;
        return this;
    }
}
