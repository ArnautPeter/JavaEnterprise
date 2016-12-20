package com.java.ee.lesson9.ServletTest.dao;


import com.java.ee.lesson9.ServletTest.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    List<User> addUser(User newUser);

}