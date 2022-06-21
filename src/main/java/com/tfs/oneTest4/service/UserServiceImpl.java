
/*
package com.tfs.oneTest4.service;

import com.tfs.oneTest4.domain.Role;
import com.tfs.oneTest4.domain.User;
import com.tfs.oneTest4.repo.RoleRepo;
import com.tfs.oneTest4.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;



    @Override
    public User saveUser(User user) {
        System.out.println("Saving new user to the database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        System.out.println("Saving new role to the database");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        //put validation here, this is simple implementation
        System.out.println("Adding role to user");
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        System.out.println("fetching user");
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        System.out.println("getting all users");
        return userRepo.findAll();
    }
}



 */
