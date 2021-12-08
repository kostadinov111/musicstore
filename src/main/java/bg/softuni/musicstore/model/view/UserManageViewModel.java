package bg.softuni.musicstore.model.view;

public class UserManageViewModel {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean isEnabled;

    public UserManageViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UserManageViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserManageViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserManageViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserManageViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserManageViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public UserManageViewModel setEnabled(Boolean enabled) {
        isEnabled = enabled;
        return this;
    }
}
