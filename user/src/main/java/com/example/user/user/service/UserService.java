package com.example.user.user.service;

import com.example.user.user.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);

    List<User> getallUsers();

    User updateUser(User user);

    void deleteUser(Long userId);


}
