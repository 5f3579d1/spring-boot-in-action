package org.example.myproject.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by k on 9/15/15.
 */
@Entity
@Table(name = "user")
public class User extends BaseModel {

    @NotNull
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    private String email;

    @NotNull
    private boolean enable = true;

    @ManyToMany
    protected Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
