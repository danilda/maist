package ua.com.maist.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dach1016 on 24.07.2017.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String role;
    @Version
    private int version;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", version=" + version +
                '}';
    }
}
