package com.java.ee.lesson6.ioc_di2.repo;

import com.java.ee.lesson6.ioc_di2.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "userRepo2")
public class UserRepoImpl2 implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("repo2 xxx1", 13),
                new User("repo2 xxx2", 14),
                new User("repo2 xxx3", 15),
                new User("repo2 xxx4", 16)
        );
    }

}
