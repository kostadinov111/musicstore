package bg.softuni.musicstore.model.entity;

import bg.softuni.musicstore.model.enums.GenreEnums;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity {

    private String name;
    private LocalDate released;
    private BigDecimal price;
    private GenreEnums genre;
    private MusicianEntity musician;

    public AlbumEntity() {
    }

    @Column(nullable = false)
    @Size(max = 50)
    public String getName() {
        return name;
    }

    public AlbumEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public LocalDate getReleased() {
        return released;
    }

    public AlbumEntity setReleased(LocalDate released) {
        this.released = released;
        return this;
    }

    @Column(nullable = false)
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public GenreEnums getGenre() {
        return genre;
    }

    public AlbumEntity setGenre(GenreEnums genre) {
        this.genre = genre;
        return this;
    }

    @ManyToOne
    public MusicianEntity getMusician() {
        return musician;
    }

    public AlbumEntity setMusician(MusicianEntity musician) {
        this.musician = musician;
        return this;
    }
}