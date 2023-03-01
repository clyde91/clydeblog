package com.clyde.blog.controller;

import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.User;
import com.clyde.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clyde
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult<User> login(User user) {
        User result = userService.login(user);
        return (result != null) ? CommonResult.success(result) : CommonResult.failed();
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<Boolean> register(@RequestBody User user) {
        Boolean result=userService.register(user);
        return (result != null) ? CommonResult.success(result) : CommonResult.failed();
    }
}
