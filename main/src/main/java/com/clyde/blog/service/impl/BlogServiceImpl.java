package com.clyde.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.dao.BlogDAO;
import com.clyde.blog.model.Blog;
import com.clyde.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author clyde
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogDAO, Blog> implements BlogService {
    @Autowired
    private BlogDAO blogDAO;
//    @Override
//    public List<Blog> getList() {
//        List<Blog> blogList = blogDAO.queryBlogList();
//        return blogList;
//    }

    @Override
    public IPage<Blog> getBlogListByCategoryId(IPage<Blog> iPage, Integer category_id) {
        return blogDAO.selectBlogListByCategoryId(iPage, category_id);
    }

    @Override
    public IPage<Blog> getBlogListByApi(IPage<Blog> iPage, Integer parent_id) {
        return blogDAO.selectBlogListByApi(iPage, parent_id);
    }


    @Override
    public void updateBlogById(Blog blog) {
        blogDAO.updateBlogById(blog);
    }

    @Override
    public void addBlog(Blog blog) {
        blogDAO.insertBlog(blog);
    }

    @Override
    public IPage<Blog> getList(IPage<Blog> iPage) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("created_time");
        return page(iPage,queryWrapper);
    }

    @Override
    public List<Blog> getBlogListByDate(Integer num) {
        return blogDAO.selectByTime(num);
    }
}
