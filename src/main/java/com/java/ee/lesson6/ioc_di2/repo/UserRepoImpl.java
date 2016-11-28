package com.java.ee.lesson6.ioc_di2.repo;

import com.java.ee.lesson6.ioc_di2.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "userRepo")
public class UserRepoImpl implements UserRepo {

    @Override
    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("repo1 xxx1", 25),
                new User("repo1 xxx2", 15),
                new User("repo1 xxx3", 35),
                new User("repo1 xxx4", 45)
        );
    }
}
