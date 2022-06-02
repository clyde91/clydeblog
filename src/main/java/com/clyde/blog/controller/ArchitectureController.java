package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.Architecture;
import com.clyde.blog.model.ArchitectureArchitect;
import com.clyde.blog.model.ArchitectureGuessDTO;
import com.clyde.blog.service.ArchitectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author clyde
 */
@RestController
@RequestMapping("/architecture")
public class ArchitectureController {
    @Autowired
    private ArchitectureService architectureService;

    //分页返回全部建筑
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<Architecture>> getListByIndexPages(@PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<Architecture> iPage = new Page<>(index, size);
        IPage<Architecture> page = architectureService.page(iPage);
        return CommonResult.success(page);
    }

    //分页返回全部建筑(带参数查询)
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.POST)
    public CommonResult<IPage<Architecture>> getListByIndexPagesFilter(@PathVariable("index") Integer index, @PathVariable("size") Integer size, @RequestBody Architecture architecture) {
        IPage<Architecture> iPage = new Page<>(index, size);
        IPage<Architecture> page = architectureService.getListByFilter(iPage, architecture);
        return CommonResult.success(page);
    }

    //根据id返回建筑内容
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<Architecture> getArchitectureById(@PathVariable("id") Integer id) {
        Architecture architecture = architectureService.getById(id);
        //如果建筑师为空。返回一个空建筑师
        if (architecture.getArchitect() == null) {
            ArchitectureArchitect architect = new ArchitectureArchitect();
            architecture.setArchitect(architect);
        }
        return CommonResult.success(architecture);
    }

    //更新或者添加建筑
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateArchitecture(@RequestBody Architecture architecture) {
        if (architecture.getId() == null) {
            architectureService.addArchitecture(architecture);
        } else {
            architectureService.updateArchitectureById(architecture);
        }
    }

    //删除建筑
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void delArchitectureById(Integer id) {
        architectureService.delArchitectureById(id);
    }

    //猜建筑游戏。返回12个建筑
    @RequestMapping(value = "/guest", method = RequestMethod.GET)
    public CommonResult<List<ArchitectureGuessDTO>> getArchitecturesRandomly(Integer count) {
        List<ArchitectureGuessDTO> list = architectureService.getRandomArchitecture(count);
        return CommonResult.success(list);
    }
}
