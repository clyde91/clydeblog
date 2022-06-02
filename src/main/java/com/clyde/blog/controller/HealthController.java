package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.Blog;
import com.clyde.blog.model.Health;
import com.clyde.blog.service.BlogService;
import com.clyde.blog.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author clyde
 */
@RestController
@RequestMapping("/health")
public class HealthController {
    @Autowired
    private HealthService healthService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult<List<Health>> getList() {
        List<Health> list = healthService.list();
        return CommonResult.success(list);
    }

    //分页
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<Health>> getListByPage(@PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<Health> iPage = new Page<>(index, size);
        IPage<Health> page = healthService.page(iPage);
        return CommonResult.success(page);
    }

    //根据id获得信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<Health> getHealthById(@PathVariable("id") Integer id) {
        Health health = healthService.getById(id);
        return CommonResult.success(health);
    }

    //更新体重
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateBlog(@RequestBody Health health) {
        if (health.getId() == null) {
            if (health.getRecordDate() == null) {
                health.setRecordDate(new Date());
            }
            healthService.save(health);
        }
        healthService.updateById(health);
    }
    //删除体重
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    public void delHealthById(Integer id){
        healthService.removeById(id);
    }
}
