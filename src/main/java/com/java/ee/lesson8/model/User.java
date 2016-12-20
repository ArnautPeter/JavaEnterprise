package com.java.ee.lesson8.model;

public class User {

    private String name;
    private int age;
    private String password;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
