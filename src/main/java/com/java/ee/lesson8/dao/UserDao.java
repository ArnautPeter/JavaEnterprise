package com.java.ee.lesson8.dao;


import com.java.ee.lesson8.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    List<User> addUser(User newUser);

}