package bg.softuni.musicstore.model.binding;

import bg.softuni.musicstore.model.enums.GenreEnums;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumBindingModel {

    private Long id;
    private String name;
    private LocalDate released;
    private BigDecimal price;
    private GenreEnums genre;

    public AlbumBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    @NotNull
    @Size(max = 50)
    public String getName() {
        return name;
    }

    public AlbumBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    public LocalDate getReleased() {
        return released;
    }

    public AlbumBindingModel setReleased(LocalDate released) {
        this.released = released;
        return this;
    }

    @NotNull
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull
    public GenreEnums getGenre() {
        return genre;
    }

    public AlbumBindingModel setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }
}
