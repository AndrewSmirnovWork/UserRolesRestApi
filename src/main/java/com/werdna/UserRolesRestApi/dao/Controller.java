package com.werdna.UserRolesRestApi.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.werdna.UserRolesRestApi.entity.User;
import com.werdna.UserRolesRestApi.service.UserService;
import com.werdna.UserRolesRestApi.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @JsonView(Views.Public.class)
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{login}")
    @JsonView(Views.Internal.class)
    public Optional<User> getUserByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @PostMapping("/user")
    public User addUser(@Valid @RequestBody User user) {
        userService.save(user);
        return user;
    }

    @DeleteMapping("/user/{login}")
    public void deleteUserByLogin(@PathVariable String login) {
        userService.delete(login);
    }

}
