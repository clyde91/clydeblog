package com.clyde.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clyde.blog.model.Architecture;
import com.clyde.blog.model.ArchitectureGuessDTO;

import java.util.List;

/**
 * @author clyde
 */
public interface ArchitectureService extends IService<Architecture> {
    //更新建筑
    void updateArchitectureById(Architecture architecture);

    //添加建筑
    void addArchitecture(Architecture architecture);

    //删除建筑
    void delArchitectureById(Integer id);

    //根据条件返回列表
    IPage<Architecture> getListByFilter(IPage<Architecture> iPage, Architecture architecture);
    //获得随机几个建筑
    List<ArchitectureGuessDTO> getRandomArchitecture(Integer count);
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
