package bg.softuni.musicstore.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = "event-musicians",
        attributeNodes = {
                @NamedAttributeNode("musicians")
        }
)
@Entity
@Table(name = "events")
public class EventEntity extends BaseEntity {

    private String name;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private List<MusicianEntity> musicians = new ArrayList<>();
    private String createdBy;

    public EventEntity() {
    }

    @Column(nullable = false)
    @Size(max = 100)
    public String getName() {
        return name;
    }

    public EventEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public EventEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column
    @Size(max = 150)
    public String getLocation() {
        return location;
    }

    public EventEntity setLocation(String location) {
        this.location = location;
        return this;
    }

    @Column(name = "date_time", nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public EventEntity setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
    public List<MusicianEntity> getMusicians() {
        return musicians;
    }

    public EventEntity setMusicians(List<MusicianEntity> musicians) {
        this.musicians = musicians;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public EventEntity setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}