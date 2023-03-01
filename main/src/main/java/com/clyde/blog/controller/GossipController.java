package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.Gossip;
import com.clyde.blog.service.GossipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author clyde
 */
@RestController
@RequestMapping("/gossip")
public class GossipController {
    @Autowired
    private GossipService gossipService;

    //传给首页
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult<List<String>> getList() {
        List<Gossip> gossips = gossipService.list();
        List<String> list = new ArrayList<>();
        for (Gossip gossip : gossips) {
            list.add(gossip.getText());
        }
        return CommonResult.success(list);
    }

    //根据分页返回gossip
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<Gossip>> getListByPage(@PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<Gossip> iPage = new Page<>(index, size);
        IPage<Gossip> page = gossipService.getList(iPage);
        return CommonResult.success(page);
    }

    //根据id返回gossip内容
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<Gossip> getGossip(@PathVariable("id") Integer id) {
        Gossip gossip = gossipService.getById(id);
        return CommonResult.success(gossip);
    }

    //添加gossip
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addGossip(@RequestBody Gossip gossip) {
        gossip.setCreatedTime(new Date());
        gossipService.save(gossip);
    }

    //更新gossip
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateBlog(@RequestBody Gossip gossip) {
        if (gossip.getId() == null) {
            if (gossip.getCreatedTime() == null) {
                gossip.setCreatedTime(new Date());
            }
            gossipService.save(gossip);
        }
        gossipService.updateById(gossip);
    }

    //删除gossip
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void delGossipById(Integer id) {
        gossipService.removeById(id);
    }
}
