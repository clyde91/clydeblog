package com.clyde.blog.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.dao.ArchitectureArchitectDAO;
import com.clyde.blog.dao.ArchitectureDAO;
import com.clyde.blog.dao.ArchitectureFeatureDAO;
import com.clyde.blog.model.ArchitectureArchitect;
import com.clyde.blog.model.ArchitectureFeature;
import com.clyde.blog.service.ArchitectureArchitectService;
import com.clyde.blog.service.ArchitectureFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author clyde
 */
@Service
public class ArchitectureFeatureServiceImpl extends ServiceImpl<ArchitectureFeatureDAO, ArchitectureFeature> implements ArchitectureFeatureService {
    @Autowired
    private ArchitectureFeatureDAO architectureFeatureDAO;

    @Override
    public List<ArchitectureFeature> getFeaturesByParentId(Integer parentId) {
        QueryWrapper<ArchitectureFeature> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ArchitectureFeature::getParentId,parentId);
        return list(queryWrapper);
    }


//    @Override
//    public List<Architecture> getList() {
//        List<Architecture> architectureList = architectureDAO.queryArchitectureList();
//        return architectureList;
//    }

//    @Override
//    public IPage<Architecture> getArchitectureListByCategoryId(IPage<Architecture> iPage, Integer category_id) {
//        return architectureDAO.selectArchitectureListByCategoryId(iPage, category_id);
//    }
//
//    @Override
//    public IPage<Architecture> getArchitectureListByApi(IPage<Architecture> iPage, Integer parent_id) {
//        return architectureDAO.selectArchitectureListByApi(iPage, parent_id);
//    }
//
//
//    @Override
//    public void updateArchitectureById(Architecture architecture) {
//        architectureDAO.updateArchitectureById(architecture);
//    }
//
//    @Override
//    public void addArchitecture(Architecture architecture) {
//        architectureDAO.insertArchitecture(architecture);
//    }
//
//    @Override
//    public List<Architecture> getArchitectureListByDate(Integer num) {
//        return architectureDAO.selectByTime(num);
//    }
}
