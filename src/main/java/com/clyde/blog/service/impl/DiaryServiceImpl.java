package com.clyde.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.dao.DiaryDAO;
import com.clyde.blog.model.Diary;
import com.clyde.blog.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author clyde
 */
@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryDAO, Diary> implements DiaryService {
    @Autowired
    private DiaryDAO diaryDAO;

    @Override
    public boolean updateHiddenById(Integer id, Boolean hidden) {
        UpdateWrapper<Diary> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("hidden",hidden).eq("id",id);
        return update(updateWrapper);
    }

    @Override
    public IPage<Diary> getPublicDiary(IPage<Diary> iPage) {
        QueryWrapper<Diary> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("hidden",false).orderByDesc("created_time");
        return page(iPage,queryWrapper);
    }
}
