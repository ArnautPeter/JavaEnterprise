package com.java.ee.lesson6.ioc_di.repo;

import com.java.ee.lesson6.ioc_di.User;

import java.util.Arrays;
import java.util.List;

public class UserRepoImpl implements UserRepo {

    @Override
    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("xxx1", 25),
                new User("xxx2", 15),
                new User("xxx3", 35),
                new User("xxx4", 45)
        );
    }
}
