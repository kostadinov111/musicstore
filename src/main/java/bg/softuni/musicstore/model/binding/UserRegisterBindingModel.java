package bg.softuni.musicstore.model.binding;

import javax.validation.constraints.*;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;

    public UserRegisterBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @NotBlank
    @Email
    @Size(min = 3, message = "Enter valid email address.")
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters.")
    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotBlank
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters.")
    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @NotNull
    @Min(value = 18, message = "Age must not be less than 18")
    public Integer getAge() {
        return age;
    }

    public UserRegisterBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }
}