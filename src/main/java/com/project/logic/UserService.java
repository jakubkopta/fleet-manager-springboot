package com.project.logic;

import com.project.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    User getUserById(int id);
    User updateUser(User user);
    void deleteUserById(int id);
}
