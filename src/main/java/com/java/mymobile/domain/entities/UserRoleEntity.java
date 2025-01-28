package com.java.mymobile.domain.entities;



import com.java.mymobile.domain.enums.UserRoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "userRole")
public class UserRoleEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;



    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }
}
