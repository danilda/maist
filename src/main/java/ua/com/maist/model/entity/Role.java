package ua.com.maist.model.entity;

import javax.persistence.*;

/**
 * Created by dach1016 on 24.07.2017.
 *
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private int roleId;
    private String role;
    private int version;

    protected Role() {
    }

    public Role(String role, int version) {
        this.role = role;
        this.version = version;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
}
