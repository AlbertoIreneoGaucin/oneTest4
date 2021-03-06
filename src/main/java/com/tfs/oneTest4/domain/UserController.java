package com.tfs.oneTest4.domain;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;



    @GetMapping
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }
}
