package com.example.copsboot.user;

import com.example.orm.jpa.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "copsboot_user")
public class User extends AbstractEntity<UserId> {
    @Id
    private UUID id;

    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;


    protected User() {

    }

    public User(UserId id, String email, String password, Set<UserRole> roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }
    public enum UserRole {
        OFFICER,
        CAPTAIN,
        ADMIN
    }
}
