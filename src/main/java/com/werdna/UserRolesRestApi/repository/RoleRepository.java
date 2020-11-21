package com.werdna.UserRolesRestApi.repository;

import com.werdna.UserRolesRestApi.entity.Role;
import com.werdna.UserRolesRestApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    Boolean existsByName(String name);
}
