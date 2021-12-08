package bg.softuni.musicstore.model.entity;

import bg.softuni.musicstore.model.enums.RoleNameEnums;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    private RoleNameEnums role;

    public RoleEntity() {
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnums getRole() {
        return role;
    }

    public RoleEntity setRole(RoleNameEnums role) {
        this.role = role;
        return this;
    }
}