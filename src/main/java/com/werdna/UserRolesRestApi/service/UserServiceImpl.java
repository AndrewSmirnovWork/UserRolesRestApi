package com.werdna.UserRolesRestApi.service;

import com.werdna.UserRolesRestApi.dao.UserRepository;
import com.werdna.UserRolesRestApi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;


    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<User> findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void delete(String login) {
        userRepo.deleteById(login);
    }
}
