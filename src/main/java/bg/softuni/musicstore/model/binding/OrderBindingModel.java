package bg.softuni.musicstore.model.binding;

import bg.softuni.musicstore.model.entity.AlbumEntity;
import bg.softuni.musicstore.model.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderBindingModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private List<AlbumEntity> albums = new ArrayList<>();
    private UserEntity user;

    public OrderBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderBindingModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public OrderBindingModel setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public OrderBindingModel setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
