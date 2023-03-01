package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.ArchitectureArchitect;
import com.clyde.blog.service.ArchitectureArchitectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author clyde
 */
@RestController
@RequestMapping("/architecture/architect")
public class ArchitectureArchitectController {
    @Autowired
    private ArchitectureArchitectService architectureArchitectService;

    //分页返回全部博客
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<ArchitectureArchitect>> getListByIndexPages(@PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<ArchitectureArchitect> iPage = new Page<>(index, size);
        IPage<ArchitectureArchitect> page = architectureArchitectService.page(iPage);
        return CommonResult.success(page);
    }

    //根据名字模糊查询
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public CommonResult<List<ArchitectureArchitect>> getArchitectByName(String name) {
        List<ArchitectureArchitect> architect = architectureArchitectService.getArchitectByName(name);
        return CommonResult.success(architect);

    }

    //根据id返回建筑师内容
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<ArchitectureArchitect> getArchitectureArchitectById(@PathVariable("id") Integer id) {
        ArchitectureArchitect architect = architectureArchitectService.getById(id);
        return CommonResult.success(architect);
    }

    //更新或者添加博客
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateArchitectureArchitect(@RequestBody ArchitectureArchitect architect) {
        if (architect.getId() == null) {
            architectureArchitectService.save(architect);
        } else {
            architectureArchitectService.updateById(architect);
        }
    }

    //删除建筑师
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void delArchitectureArchitectById(Integer id) {
        architectureArchitectService.removeById(id);
    }
}
