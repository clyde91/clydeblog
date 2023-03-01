package com.clyde.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.dao.UserDAO;
import com.clyde.blog.model.User;
import com.clyde.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author clyde
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(User user) {
        return userDAO.login(user);
    }

    @Override
    public Boolean register(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername,user.getUsername());
        User one = getOne(queryWrapper);
        if (one==null){
            return save(user);
        }else {
        return false;}
    }
}
