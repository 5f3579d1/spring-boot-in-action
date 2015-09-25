package org.example.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by k on 9/15/15.
 */
@Entity
@Table(name = "whw_user")
public class User extends BaseModel {

    @NotNull
    @Column(length = 32)
    private String username;

    @Column(nullable = false, length = 128)
    private String password;

    private String email;

    @NotNull
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean enable = Boolean.TRUE;

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                ", roles=" + roles +
                '}';
    }

}
