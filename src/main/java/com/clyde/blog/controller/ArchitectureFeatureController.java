package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.ArchitectureFeature;
import com.clyde.blog.service.ArchitectureFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author clyde
 */
@RestController
@RequestMapping("/architecture/feature")
public class ArchitectureFeatureController {
    @Autowired
    private ArchitectureFeatureService architectureFeatureService;

    //返回全部特点
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult<List<ArchitectureFeature>> getFeatures() {
        List<ArchitectureFeature> features = architectureFeatureService.list();
        return CommonResult.success(features);
    }

    //分页返回全部特点
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<ArchitectureFeature>> getListByIndexPages(@PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<ArchitectureFeature> iPage = new Page<>(index, size);
        IPage<ArchitectureFeature> page = architectureFeatureService.page(iPage);
        System.out.println(page);
        return CommonResult.success(page);
    }

    //返回全部父特点
    @RequestMapping(value = "/father", method = RequestMethod.GET)
    public CommonResult<List<ArchitectureFeature>> getFatherFeatures() {
        List<ArchitectureFeature> features = architectureFeatureService.getFeaturesByParentId(0);
        return CommonResult.success(features);
    }

//    //根据名字模糊查询
//    @RequestMapping(value = "/search",method = RequestMethod.GET)
//    public CommonResult<List<ArchitectureArchitect>> getArchitectByName(String name){
//        System.out.println("name = " + name);
//        List<ArchitectureArchitect> architect = architectureArchitectService.getArchitectByName(name);
//        System.out.println("architect = " + architect);
//        return CommonResult.success(architect);

    //    //根据分类     分页返回博客
//    @RequestMapping(value = "/{api}/{category}/{index}/{size}", method = RequestMethod.GET)
//    public CommonResult<IPage<Architecture>> getListByCategoryIndexPages(@PathVariable("api") String api, @PathVariable("category") Integer category, @PathVariable("index") Integer index, @PathVariable("size") Integer size) {
//        IPage<Architecture> iPage = new Page<>(index, size);
//        System.out.println("category = " + category);
//        IPage<Architecture> page = blogService.getArchitectureListByCategoryId(iPage, category);
//        return CommonResult.success(page);
//    }
//
//    //根据博客大类 分页返回博客
//    @RequestMapping(value = "/{api}/{index}/{size}", method = RequestMethod.GET)
//    public CommonResult<IPage<Architecture>> getListByApiIndexPages(@PathVariable("api") String api, @PathVariable("index") Integer index, @PathVariable("size") Integer size) {
//        IPage<Architecture> iPage = new Page<>(index, size);
//        Integer parent_id = "codeblog".equals(api) ? 1 : 0;
//        System.out.println("parent_id = " + parent_id);
//        IPage<Architecture> page = blogService.getArchitectureListByApi(iPage, parent_id);
//        return CommonResult.success(page);
//    }
//
    //根据id返回建筑特点内容
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<ArchitectureFeature> getArchitectureFeatureById(@PathVariable("id") Integer id) {
        ArchitectureFeature feature = architectureFeatureService.getById(id);
        return CommonResult.success(feature);
    }

    //    //首页返回最新6条博客
//    @RequestMapping(value = "/blog/index", method = RequestMethod.GET)
//    public CommonResult<List<Architecture>> getArchitectureByDate() {
//        List<Architecture> blog = blogService.getArchitectureListByDate(6);
//        System.out.println(blog);
//        return CommonResult.success(blog);
//    }
//
//
//    //添加博客
//    @RequestMapping(value = "/blog/add", method = RequestMethod.POST)
//    public void addArchitecture(@RequestBody Architecture blog) {
//        blogService.save(blog);
//    }
//
    //更新或者添加特点
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateArchitectureFeature(@RequestBody ArchitectureFeature feature) {
        if (feature.getId() == null) {
            architectureFeatureService.save(feature);
        } else {
            architectureFeatureService.updateById(feature);
        }
    }

    //删除特点
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void delArchitectureFeatureById(Integer id) {
        architectureFeatureService.removeById(id);
    }
}
