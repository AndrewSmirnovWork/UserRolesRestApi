package com.werdna.UserRolesRestApi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.werdna.UserRolesRestApi.entity.User;
import com.werdna.UserRolesRestApi.service.UserService;
import com.werdna.UserRolesRestApi.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @JsonView(Views.Public.class)
    public ResponseEntity<List<User>> getAll() {
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/user/{login}")
    @JsonView(Views.Internal.class)
    public ResponseEntity <User> getUserByLogin(@PathVariable String login) {
        User user = userService.findByLogin(login);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/user")
    @JsonView(Views.Internal.class)
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User newUser = userService.addUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{login}")
    @JsonView(Views.Internal.class)
    public ResponseEntity deleteUserByLogin(@PathVariable String login) {
        userService.delete(login);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/user/{login}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User newUser,
                                           @PathVariable(value = "login") String login) {
        User updatedUser = userService.updateUser(newUser, login);

        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }
}
