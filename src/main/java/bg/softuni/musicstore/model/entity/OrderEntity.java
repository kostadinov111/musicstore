package bg.softuni.musicstore.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    private static Long NUMBER_OF_ORDER = 0L;

    private String name = "my order" + ++NUMBER_OF_ORDER;
    private String description = "my description";
    private BigDecimal price;
    private LocalDateTime orderTime = LocalDateTime.now();
    private AlbumEntity album;
    private UserEntity user;

    public OrderEntity() {
    }

    @Column(nullable = false)
    @Size(max = 50)
    public String getName() {
        return name;
    }

    public OrderEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public OrderEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public OrderEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "order_time", nullable = false)
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderEntity setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public OrderEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    @ManyToOne
    public AlbumEntity getAlbum() {
        return album;
    }

    public OrderEntity setAlbum(AlbumEntity album) {
        this.album = album;
        return this;
    }
}