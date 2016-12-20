package com.java.ee.lesson9.ServletTest.service;


import com.java.ee.lesson9.ServletTest.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> addUser(User newUser);


}
