package com.clyde.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.dao.BlogDAO;
import com.clyde.blog.dao.HealthDAO;
import com.clyde.blog.model.Health;
import com.clyde.blog.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author clyde
 */
@Service
public class HealthServiceImpl extends ServiceImpl<HealthDAO, Health> implements HealthService {
    @Autowired
    private BlogDAO healthDAO;

}
