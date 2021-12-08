package bg.softuni.musicstore.model.view;

public class UserRolesManageViewModel {

    private Long id;
    private String username;
    private Boolean isAdmin;
    private Boolean isModerator;
    private Boolean isUser;

    public UserRolesManageViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UserRolesManageViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRolesManageViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public UserRolesManageViewModel setAdmin(Boolean admin) {
        isAdmin = admin;
        return this;
    }

    public Boolean getModerator() {
        return isModerator;
    }

    public UserRolesManageViewModel setModerator(Boolean moderator) {
        isModerator = moderator;
        return this;
    }

    public Boolean getUser() {
        return isUser;
    }

    public UserRolesManageViewModel setUser(Boolean user) {
        isUser = user;
        return this;
    }
}
