package com.experiment.mybatisdemo.service;

import com.experiment.mybatisdemo.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    int create(User user);

    int update(User user);

    int delete(Long id);
}
