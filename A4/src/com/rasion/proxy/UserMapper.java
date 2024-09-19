package com.rasion.proxy;

public interface UserMapper {
    User add(User user);
    void delete(String email);
    void update(User user);
}
