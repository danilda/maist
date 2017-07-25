package com.store.onlinestore.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dach1016 on 20.07.2017.
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;
    @Column(unique = true)
    private String login;
    private String password;
    private String email;
    private int active;
    private int version;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    protected User() {
    }

    public User(String login, String password, String email, int active, int version, Set<Role> roles) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.active = active;
        this.version = version;
        this.roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        roles.forEach((e)->sb.append(e.getRole()).append(", "));
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", version=" + version +
                ", roles=" + sb.toString() +
                '}';
    }
}
