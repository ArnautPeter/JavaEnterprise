package com.java.ee.homework10.service;
import com.java.ee.homework10.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> addUser(User newUser);


}