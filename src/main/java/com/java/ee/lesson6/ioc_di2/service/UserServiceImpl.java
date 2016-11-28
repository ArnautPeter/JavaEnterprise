package com.java.ee.lesson6.ioc_di2.service;

import com.java.ee.lesson6.ioc_di2.User;
import com.java.ee.lesson6.ioc_di2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

 //   @Autowired
   // @Qualifier(value = "userRepo2")
   // private UserRepo userRepo;

    @Resource
    @Qualifier(value = "userRepo2")
    private UserRepo userRepo;

    public UserServiceImpl() {
    }

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
