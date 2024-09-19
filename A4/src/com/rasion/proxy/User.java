package com.rasion.proxy;

public class User implements UserMapper {
    private String name;
    private String password;
    private String email;

    public User() {
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public User add(User user) {
        System.out.println("添加用户成功");

        return user;
    }

    @Override
    public void delete(String email) {
        System.out.println("删除用户成功");
    }

    @Override
    public void update(User user) {
        System.out.println("修改用户成功");
    }
}
