package com.java.ee.lesson6.ioc_di.repo;

import com.java.ee.lesson6.ioc_di.User;

import java.util.Arrays;
import java.util.List;


public class UserRepoImpl2 implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("xxx1", 13),
                new User("xxx2", 14),
                new User("xxx3", 15),
                new User("xxx4", 16)
        );
    }

}
