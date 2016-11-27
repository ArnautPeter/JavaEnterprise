package com.java.ee.lesson6.ioc_di.repo;

import com.java.ee.lesson6.ioc_di.User;

import java.util.List;

public interface UserRepo {

    List<User> getAllUsers();
}
