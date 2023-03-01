package com.clyde.blog.service;

/**
 * @author clyde
 */
public interface UserService {
    public User login(User user);

    Boolean register(User user);
}
