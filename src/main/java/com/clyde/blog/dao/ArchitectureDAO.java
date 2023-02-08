package com.clyde.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clyde.blog.common.api.RedisCache;
import com.clyde.blog.model.Architecture;
import com.clyde.blog.model.ArchitectureFeature;
import com.clyde.blog.model.Blog;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author clyde
 */
@CacheNamespace(implementation = RedisCache.class)
public interface ArchitectureDAO extends BaseMapper<Architecture> {
    void updateArchitectureById(Architecture architecture);

    int insertArchitecture(Architecture architecture);
    //根据给的list进行中间表的增删。
//    void  updateFeaturesById(Integer id, List<ArchitectureFeature> features);
//    //在中间表增加该特点
//  void  insertFeatureById(ArchitectureFeature feature,Integer id);
    //在中间表增加该特点
  void  insertFeaturesById(@Param("features")List<ArchitectureFeature> features, @Param("id")Integer id);
//  //在中间表删除该特点
//  void  delFeatureById(ArchitectureFeature feature,Integer id);
  //在中间表删除所有特点
  void  delFeaturesById(Integer id);
    //根据条件返回列表
    IPage<Architecture> selectListByFilter(IPage<Architecture> iPage, Architecture architecture);
    //返回总条数
    int selectCount();
    //获取建筑名字
    List<String> getArchitectureNames(Set<Integer> list);
    //获取所有国家
    List<String> selectAllCountry();
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
