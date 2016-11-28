package com.java.ee.lesson6.ioc_di2.repo;

import com.java.ee.lesson6.ioc_di2.User;

import java.util.List;

public interface UserRepo {

    List<User> getAllUsers();
}
