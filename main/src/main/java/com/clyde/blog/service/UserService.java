package com.clyde.blog.service;

import com.clyde.blog.model.User;

/**
 * @author clyde
 */
public interface UserService {
    public User login(User user);

    Boolean register(User user);
}
