package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.Blog;
import com.clyde.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * @author clyde
 */
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    //分页返回全部博客
    @RequestMapping(value = "/blog/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<Blog>> getListByIndexPages(@PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<Blog> iPage = new Page<>(index, size);
        IPage<Blog> page = blogService.getList(iPage);
        return CommonResult.success(page);
    }

    //根据分类     分页返回博客
    @RequestMapping(value = "/{api}/{category}/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<Blog>> getListByCategoryIndexPages(@PathVariable("api") String api, @PathVariable("category") Integer category, @PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<Blog> iPage = new Page<>(index, size);
        IPage<Blog> page = blogService.getBlogListByCategoryId(iPage, category);
        return CommonResult.success(page);
    }

    //根据博客大类 分页返回博客
    @RequestMapping(value = "/{api}/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<Blog>> getListByApiIndexPages(@PathVariable("api") String api, @PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<Blog> iPage = new Page<>(index, size);
        Integer parent_id = "codeblog".equals(api) ? 1 : 0;
        IPage<Blog> page = blogService.getBlogListByApi(iPage, parent_id);
        return CommonResult.success(page);
    }

    //根据id返回博客内容
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public CommonResult<Blog> getBlogById(@PathVariable("id") Integer id) {
        Blog blog = blogService.getById(id);
        return CommonResult.success(blog);
    }
    //首页返回最新6条博客
    @RequestMapping(value = "/blog/index", method = RequestMethod.GET)
    public CommonResult<List<Blog>> getBlogByDate() {
        List<Blog> blog = blogService.getBlogListByDate(6);
        return CommonResult.success(blog);
    }


    //添加博客
    @RequestMapping(value = "/blog/add", method = RequestMethod.POST)
    public void addBlog(@RequestBody Blog blog) {
        blogService.save(blog);
    }

    //更新或者添加博客
    @RequestMapping(value = "/blog/update", method = RequestMethod.POST)
    public void updateBlog(@RequestBody Blog blog) {
        if (blog.getId() == null) {
            if (blog.getCreatedTime() == null) {
                blog.setCreatedTime(new Date());
            }
            blog.setModifiedTime(new Date());
            //作者默认设置1
            blog.getAuthor().setId(1);
            blogService.addBlog(blog);
        } else {
            blogService.updateBlogById(blog);
        }
    }

    //删除博客
    @RequestMapping(value = "/blog/del", method = RequestMethod.DELETE)
    public void delBlogById(Integer id) {
        blogService.removeById(id);
    }
}
