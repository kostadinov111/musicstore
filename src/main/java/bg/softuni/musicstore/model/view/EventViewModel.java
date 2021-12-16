package bg.softuni.musicstore.model.view;

import bg.softuni.musicstore.model.dto.MusicianDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventViewModel {

    private Long id;
    private String name;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private List<MusicianDTO> musicians = new ArrayList<>();
    private String createdBy;

    public EventViewModel() {
    }

    public Long getId() {
        return id;
    }

    public EventViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EventViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EventViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public EventViewModel setLocation(String location) {
        this.location = location;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public EventViewModel setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public List<MusicianDTO> getMusicians() {
        return musicians;
    }

    public EventViewModel setMusicians(List<MusicianDTO> musicians) {
        this.musicians = musicians;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public EventViewModel setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
