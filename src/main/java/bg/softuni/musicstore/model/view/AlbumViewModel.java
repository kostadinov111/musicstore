package bg.softuni.musicstore.model.view;

import bg.softuni.musicstore.model.enums.GenreEnums;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {

    private Long id;
    private String name;
    private LocalDate released;
    private BigDecimal price;
    private GenreEnums genre;
    private Long OwnerId;

    public AlbumViewModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getReleased() {
        return released;
    }

    public AlbumViewModel setReleased(LocalDate released) {
        this.released = released;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public GenreEnums getGenre() {
        return genre;
    }

    public AlbumViewModel setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }

    public Long getOwnerId() {
        return OwnerId;
    }

    public AlbumViewModel setOwnerId(Long ownerId) {
        OwnerId = ownerId;
        return this;
    }
}
