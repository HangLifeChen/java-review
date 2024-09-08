package com.rasion.PMS.bean;

public class User {
    private String username;
    private String password;
    private String loginName;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loginName='" + loginName + '\'' +
                '}';
    }

    public User() {
    }

    public User(String username, String password, String loginName) {
        this.username = username;
        this.password = password;
        this.loginName = loginName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
