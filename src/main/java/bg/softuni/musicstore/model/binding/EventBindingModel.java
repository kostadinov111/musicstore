package bg.softuni.musicstore.model.binding;

import java.time.LocalDateTime;

public class EventBindingModel {

    private Long id;
    private String name;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private String createdBy;

    public EventBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public EventBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EventBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EventBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public EventBindingModel setLocation(String location) {
        this.location = location;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public EventBindingModel setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public EventBindingModel setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
