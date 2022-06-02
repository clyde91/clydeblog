package com.clyde.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.dao.BlogDAO;
import com.clyde.blog.dao.GossipDAO;
import com.clyde.blog.dao.HealthDAO;
import com.clyde.blog.model.Gossip;
import com.clyde.blog.model.Health;
import com.clyde.blog.service.GossipService;
import com.clyde.blog.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author clyde
 */
@Service
public class GossipServiceImpl extends ServiceImpl<GossipDAO, Gossip> implements GossipService {
    @Autowired
    private GossipDAO gossipDAO;

    @Override
    public IPage<Gossip> getList(IPage<Gossip> iPage) {
        QueryWrapper<Gossip> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("created_time");
        return page(iPage,queryWrapper);
    }
}
