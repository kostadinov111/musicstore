package bg.softuni.musicstore.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @NotNull
    @Size(min = 3, max = 20)
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}