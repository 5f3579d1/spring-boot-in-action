package org.example.myproject.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by k on 9/15/15.
 */
@Entity
public class Account extends TransactionalEntity {

    @Column(nullable = false, length = 32)
    private String username;

    @JsonIgnore
    @Column(nullable = false, length = 128)
    private String password;

    private String email;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean enable = Boolean.TRUE;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean credentialsExpired = false;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean expired = false;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean locked = false;

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

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                ", roles=" + roles +
                '}';
    }

}
