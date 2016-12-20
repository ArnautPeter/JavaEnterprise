package com.java.ee.homework10.dao;


import com.java.ee.homework10.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    List<User> addUser(User newUser);

}