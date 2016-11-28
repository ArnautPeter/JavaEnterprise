package com.java.ee.lesson6.ioc_di.service;

import com.java.ee.lesson6.ioc_di.User;
import com.java.ee.lesson6.ioc_di.repo.UserRepo;
import com.java.ee.lesson6.ioc_di.repo.UserRepoImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepo userRepo = new UserRepoImpl();

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
