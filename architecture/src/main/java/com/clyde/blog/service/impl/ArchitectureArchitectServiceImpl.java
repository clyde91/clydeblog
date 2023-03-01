package com.clyde.blog.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.dao.ArchitectureArchitectDAO;
import com.clyde.blog.model.ArchitectureArchitect;
import com.clyde.blog.service.ArchitectureArchitectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author clyde
 */
@Service
public class ArchitectureArchitectServiceImpl extends ServiceImpl<ArchitectureArchitectDAO, ArchitectureArchitect> implements ArchitectureArchitectService {
    @Autowired
    private ArchitectureArchitectDAO architectureArchitectDAO;

    @Override
    public List<ArchitectureArchitect> getArchitectByName(String name) {
        QueryWrapper<ArchitectureArchitect> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().like(ArchitectureArchitect::getName,name);
        return list(queryWrapper);
    }

    @Override
    public int getArchitectSum() {
        return architectureArchitectDAO.selectCount(new QueryWrapper<>()).intValue();
    }

    @Override
    public List<String> getArchitectNames(Set<Integer> errorNums) {
        return architectureArchitectDAO.selectArchitectNames(errorNums);
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
