package com.werdna.UserRolesRestApi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.werdna.UserRolesRestApi.validation.ValidPassword;
import com.werdna.UserRolesRestApi.views.Views;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "login")
public class User implements Serializable {

    @Column(name = "name")
    @NotBlank
    @JsonView(Views.Public.class)
    private String name;

    @Id
    @Column(name = "login")
    @JsonView(Views.Public.class)
    @NotBlank
    private String login;

    @Column(name = "password")
    @JsonView(Views.Private.class)
    @ValidPassword
    @NotBlank
    private String password;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "user_login" ),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonView(Views.Internal.class)
    private Collection<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password, Set<Role> roles) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
