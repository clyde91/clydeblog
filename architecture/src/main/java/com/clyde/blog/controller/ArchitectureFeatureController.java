package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.CommonResult;
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
        return CommonResult.success(page);
    }

    //返回全部父特点
    @RequestMapping(value = "/father", method = RequestMethod.GET)
    public CommonResult<List<ArchitectureFeature>> getFatherFeatures() {
        List<ArchitectureFeature> features = architectureFeatureService.getFeaturesByParentId(0);
        return CommonResult.success(features);
    }

    //根据id返回建筑特点内容
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<ArchitectureFeature> getArchitectureFeatureById(@PathVariable("id") Integer id) {
        ArchitectureFeature feature = architectureFeatureService.getById(id);
        return CommonResult.success(feature);
    }

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
