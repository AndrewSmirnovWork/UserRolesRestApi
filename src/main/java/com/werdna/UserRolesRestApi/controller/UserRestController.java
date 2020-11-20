package com.werdna.UserRolesRestApi.controller;

import com.werdna.UserRolesRestApi.entity.User;
import com.werdna.UserRolesRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{login}")
    public Optional<User> getUserByLogin(@PathVariable String login) {
        Optional<User> user = userService.findByLogin(login);
        return user;
    }

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user) {
        userService.save(user);
        return user;
    }

    @DeleteMapping("/users/{login}")
    public void deleteUserByLogin(String login) {
        userService.delete(login);
    }


}
