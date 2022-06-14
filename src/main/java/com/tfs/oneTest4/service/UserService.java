package com.tfs.oneTest4.service;

import com.tfs.oneTest4.domain.Role;
import com.tfs.oneTest4.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    // in the real world, return a page of users, so only the first 10 users
    List<User> getUsers();
}
