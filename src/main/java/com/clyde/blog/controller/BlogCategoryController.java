package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.Blog;
import com.clyde.blog.model.BlogCategory;
import com.clyde.blog.service.BlogCategoryService;
import com.clyde.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author clyde
 */
@RestController
@RequestMapping("/blog/category")
public class BlogCategoryController {
    @Autowired
    private BlogCategoryService blogCategoryService;


    //返回分类列表
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult<List<BlogCategory>> getList() {
        List<BlogCategory> page = blogCategoryService.list();
        return CommonResult.success(page);
    }
    //返回分类列表
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<BlogCategory>> getListByIndexPages(@PathVariable("blog") String blog, @PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<BlogCategory> iPage = new Page<>(index, size);
        IPage<BlogCategory> page = blogCategoryService.page(iPage);
        return CommonResult.success(page);
    }

    //根据id返回博客分类内容
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<BlogCategory> getBlog(@PathVariable("id") Integer id) {
        BlogCategory blogCategory =blogCategoryService.getById(id);
        return CommonResult.success(blogCategory);
    }

    //添加或更新博客分类
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateBlog(BlogCategory blogCategory){
        if (blogCategory.getId() == null) {
            blogCategoryService.save(blogCategory);
    } else {
            blogCategoryService.updateById(blogCategory);
    }
    }
    //删除博客分类
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void delBlogById(Integer id){
        blogCategoryService.removeById(id);
    }


}
