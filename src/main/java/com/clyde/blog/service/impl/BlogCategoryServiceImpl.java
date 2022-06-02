package com.clyde.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.dao.BlogCategoryDAO;
import com.clyde.blog.model.BlogCategory;
import com.clyde.blog.service.BlogCategoryService;
import org.springframework.stereotype.Service;

/**
 * @author clyde
 */
@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryDAO, BlogCategory> implements BlogCategoryService {

}
