package com.experiment.mybatisdemo.controller;

import com.experiment.mybatisdemo.entity.User;
import com.experiment.mybatisdemo.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public int create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/user")
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    public int delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
