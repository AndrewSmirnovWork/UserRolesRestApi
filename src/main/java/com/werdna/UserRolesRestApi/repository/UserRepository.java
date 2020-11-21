package com.werdna.UserRolesRestApi.repository;

import com.werdna.UserRolesRestApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByLogin(String login);

    Boolean existsByLogin(String login);

}
