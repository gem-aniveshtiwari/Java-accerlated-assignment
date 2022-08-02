package com.java.assignment4.controller;

import com.java.assignment4.Model.User;
import com.java.assignment4.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User createUser = this.userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
