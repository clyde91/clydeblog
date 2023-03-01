package com.clyde.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clyde.blog.model.ArchitectureArchitect;

import java.util.List;
import java.util.Set;

/**
 * @author clyde
 */
public interface ArchitectureArchitectService extends IService<ArchitectureArchitect> {
    List<ArchitectureArchitect> getArchitectByName(String name);
    //获取建筑师总数
    int getArchitectSum();
    //获取建筑师名字根据id
    List<String> getArchitectNames(Set<Integer> errorNums);
//    public IPage<Blog> getBlogListByCategoryId(IPage<Blog>  iPage, Integer category_id);
//    public IPage<Blog> getBlogListByApi(IPage<Blog>  iPage, Integer parent_id);
//    //首页返回最新6条博客
//    public List<Blog> getBlogListByDate(Integer num);
//    //更新博客
//   public void updateBlogById(Blog blog);
//   //添加博客
//   public void addBlog(Blog blog);
////public List<Blog> getList();
////public Blog getBlogById(Integer id);
////public void updateBlog(Blog blog);
}
