package com.clyde.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author clyde
 */
public interface UserDAO extends BaseMapper<User> {
    User login(User user);
    void register(User user);
}
