package com.werdna.UserRolesRestApi.service;

import com.werdna.UserRolesRestApi.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findByLogin(String login);

    void save(User user);

    void delete(String login);

}
