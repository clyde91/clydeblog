package com.clyde.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clyde.blog.model.Gossip;
import com.clyde.blog.model.Health;

/**
 * @author clyde
 */
public interface GossipService extends IService<Gossip> {
    //获得所有废话
    IPage<Gossip> getList(IPage<Gossip> iPage);
}
