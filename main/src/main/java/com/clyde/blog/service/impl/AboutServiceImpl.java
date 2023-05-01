package com.clyde.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.dao.AboutDAO;
import com.clyde.blog.dao.BlogDAO;
import com.clyde.blog.dao.HealthDAO;
import com.clyde.blog.model.About;
import com.clyde.blog.model.Health;
import com.clyde.blog.service.AboutService;
import com.clyde.blog.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author clyde
 */
@Service
public class AboutServiceImpl extends ServiceImpl<AboutDAO, About> implements AboutService {

}
