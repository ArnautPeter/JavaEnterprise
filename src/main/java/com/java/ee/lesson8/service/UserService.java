package com.java.ee.lesson8.service;


import com.java.ee.lesson8.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> addUser(User newUser);


}
