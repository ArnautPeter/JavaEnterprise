package com.java.ee.homework5;

public class Test {

    public static void main(String[] args) {

        User user = new User("John", 25);

        Role userRole = user.getClass().getAnnotation(UserRoleAnnotation.class).value();
        System.out.println(user + " has role: " + userRole);
    }
}
