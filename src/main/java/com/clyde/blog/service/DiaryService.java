package com.clyde.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clyde.blog.model.Diary;

/**
 * @author clyde
 */
public interface DiaryService extends IService<Diary> {
    boolean updateHiddenById(Integer id, Boolean hidden);
    IPage<Diary> getPublicDiary(IPage<Diary> iPage);
}
