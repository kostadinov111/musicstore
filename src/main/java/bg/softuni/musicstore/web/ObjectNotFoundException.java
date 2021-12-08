package bg.softuni.musicstore.web;

public class ObjectNotFoundException extends RuntimeException {

    private final Long objectId;

    public ObjectNotFoundException(Long objectId) {
        super("Object with ID " + objectId + " not found!");
        this.objectId = objectId;
    }

    public Long getObjectId() {
        return objectId;
    }
}
