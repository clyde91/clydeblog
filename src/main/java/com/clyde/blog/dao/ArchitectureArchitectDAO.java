package com.clyde.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clyde.blog.model.Architecture;
import com.clyde.blog.model.ArchitectureArchitect;

import java.util.List;
import java.util.Set;

/**
 * @author clyde
 */
public interface ArchitectureArchitectDAO extends BaseMapper<ArchitectureArchitect> {
    List<String> selectArchitectNames(Set<Integer> errorNums);
//    public IPage<Blog> selectBlogListByCategoryId(IPage<Blog> iPage,Integer category_id);
//    public IPage<Blog> selectBlogListByTable(IPage<Blog> iPage, String table_name);
//    public IPage<Blog> selectBlogListByApi(IPage<Blog> iPage, Integer parent_id);
//    //根据个数返回最新的博客
//    public List<Blog> selectByTime(Integer num);
//    //根据id更新博客
//    public void updateBlogById(Blog blog);
//    //添加博客
//    public void insertBlog(Blog blog);
}
