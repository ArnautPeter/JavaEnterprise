package com.java.ee.lesson6.ioc_di.manager;

import com.java.ee.lesson6.ioc_di.User;
import com.java.ee.lesson6.ioc_di.repo.UserRepo;
import com.java.ee.lesson6.ioc_di.service.UserService;
import com.java.ee.lesson6.ioc_di.service.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserManager {

    public static void main(String[] args) {
/*
        UserService userService = new UserServiceImpl();
        List<User> allUsers = userService.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
        */

        //  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        //  UserService userService = context.getBean("userService", UserService.class);
        //    UserRepo userRepo = context.getBean("userRepo", UserRepo.class);

        //  System.out.println(userService);
        //  System.out.println(userRepo);



    }
}
