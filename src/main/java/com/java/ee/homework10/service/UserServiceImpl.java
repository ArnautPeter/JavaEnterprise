package com.java.ee.homework10.service;

import com.java.ee.homework10.dao.UserDao;
import com.java.ee.homework10.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    public UserServiceImpl() {
        System.out.println("userService::: constructor");
    }

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public List<User> addUser(User newUser) {
        return userDao.addUser(newUser);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}