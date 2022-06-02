package com.clyde.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clyde.blog.model.Blog;

import java.util.List;

/**
 * @author clyde
 */
public interface BlogService extends IService<Blog> {
    public IPage<Blog> getBlogListByCategoryId(IPage<Blog>  iPage, Integer category_id);
    public IPage<Blog> getBlogListByApi(IPage<Blog>  iPage, Integer parent_id);
    //首页返回最新6条博客
    public List<Blog> getBlogListByDate(Integer num);
    //更新博客
   public void updateBlogById(Blog blog);
   //添加博客
   public void addBlog(Blog blog);
    //后台获得所有博客
    IPage<Blog> getList(IPage<Blog> iPage);
//public List<Blog> getList();
//public Blog getBlogById(Integer id);
//public void updateBlog(Blog blog);
}
