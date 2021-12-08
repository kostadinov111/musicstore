package bg.softuni.musicstore.model.dto;

import bg.softuni.musicstore.model.enums.GenreEnums;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumsDTO {

    private Long id;
    private String name;
    private LocalDate released;
    private BigDecimal price;
    private GenreEnums genre;
    private MusicianDTO musician;

    public AlbumsDTO() {
    }

    public Long getId() {
        return id;
    }

    public AlbumsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumsDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getReleased() {
        return released;
    }

    public AlbumsDTO setReleased(LocalDate released) {
        this.released = released;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumsDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public GenreEnums getGenre() {
        return genre;
    }

    public AlbumsDTO setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }

    public MusicianDTO getMusician() {
        return musician;
    }

    public AlbumsDTO setMusician(MusicianDTO musician) {
        this.musician = musician;
        return this;
    }
}