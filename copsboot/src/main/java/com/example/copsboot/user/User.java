package com.example.copsboot.user;

import com.example.orm.jpa.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "copsboot_user")
public class User extends AbstractEntity<UserId> {

    private String email;
    private AuthServerId authServerId;
    private String mobileToken;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;


    protected User(UserId id, String mail, String s, HashSet<UserRole> roles) {

    }

    public User(UserId id, String email, AuthServerId authServerId, String mobileToken) {
        super(id);
        this.email = email;
        this.authServerId = authServerId;
        this.mobileToken = mobileToken;
    }

    public String getEmail() {
        return email;
    }

    public AuthServerId getAuthServerId() {
        return authServerId;
    }
    public String getMobileToken() {
        return mobileToken;
    }

    public enum UserRole {
        OFFICER,
        CAPTAIN,
        ADMIN
    }
}
