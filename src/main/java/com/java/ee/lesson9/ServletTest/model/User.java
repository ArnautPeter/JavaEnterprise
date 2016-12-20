package com.java.ee.lesson9.ServletTest.model;

public class User {

    private String name;
    private int age;
    private String password;
    private String phone;
    private String email;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String password) {
        this(name, age);
        this.password = password;

    }

    public User(String name, int age, String password, String phone, String email, String address) {
        this(name, age, password);
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
