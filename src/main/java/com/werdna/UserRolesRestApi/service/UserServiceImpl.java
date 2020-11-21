package com.werdna.UserRolesRestApi.service;

import com.werdna.UserRolesRestApi.entity.Role;
import com.werdna.UserRolesRestApi.entity.User;
import com.werdna.UserRolesRestApi.exception.BadRequestException;
import com.werdna.UserRolesRestApi.payload.ApiResponse;
import com.werdna.UserRolesRestApi.repository.RoleRepository;
import com.werdna.UserRolesRestApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    private RoleRepository roleRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Transactional
    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    @Transactional
    public User addUser(User user) {
        if (userRepo.existsByLogin(user.getLogin())) {
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Login is already taken");
            throw new BadRequestException(apiResponse);
        }
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User newUser, String username) {
        User user = userRepo.getOne(username);
        if (user.getLogin().equals(newUser.getLogin())) {
            user.setName(newUser.getName());
            user.setPassword(newUser.getPassword());
            user.setRoles(newUser.getRoles());
            return userRepo.save(user);
        }
        ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Wrong login " + username);
        throw new BadRequestException(apiResponse);
    }


    @Override
    @Transactional
    public void delete(String login) {
        userRepo.deleteById(login);
    }
}
