package com.werdna.UserRolesRestApi.service;

import com.werdna.UserRolesRestApi.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByLogin(String login);

    //ApiResponse findByLogin(String login);
    User addUser(User user);

    User updateUser(User newUser, String username);

    void delete(String login);

}
