package bg.softuni.musicstore.model.entity;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = "user-roles",
        attributeNodes = {
                @NamedAttributeNode("roles")
        }
)
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean enabled = true;
    private List<RoleEntity> roles = new ArrayList<>();
//    private List<OrderEntity> orders = new ArrayList<>();
//    private List<EventEntity> events = new ArrayList<>();

    public UserEntity() {
    }

    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 20)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(nullable = false, unique = true)
    @Email
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 30)
    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 30)
    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(nullable = false)
    @Min(value = 18)
    public Integer getAge() {
        return age;
    }

    public UserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Transactional
    @ManyToMany(fetch = FetchType.LAZY)
    public List<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

//    @Transactional
//    @OneToMany(fetch = FetchType.LAZY)//, mappedBy = "user")
//    public List<OrderEntity> getOrders() {
//        return orders;
//    }
//
//    public UserEntity setOrders(List<OrderEntity> orders) {
//        this.orders = orders;
//        return this;
//    }
//
//    @Transactional
//    @OneToMany(fetch = FetchType.LAZY)//, mappedBy = "user")
//    public List<EventEntity> getEvents() {
//        return events;
//    }
//
//    public UserEntity setEvents(List<EventEntity> events) {
//        this.events = events;
//        return this;
//    }

    public Boolean getEnabled() {
        return enabled;
    }

    public UserEntity setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}