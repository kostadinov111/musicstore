package bg.softuni.musicstore.model.service;

import bg.softuni.musicstore.model.enums.GenreEnums;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumServiceModel {

    private Long id;
    private String name;
    private LocalDate released;
    private BigDecimal price;
    private GenreEnums genre;

    public AlbumServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getReleased() {
        return released;
    }

    public AlbumServiceModel setReleased(LocalDate released) {
        this.released = released;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public GenreEnums getGenre() {
        return genre;
    }

    public AlbumServiceModel setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }
}
