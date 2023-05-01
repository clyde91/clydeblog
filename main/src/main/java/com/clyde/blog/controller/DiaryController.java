package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.CommonResult;
import com.clyde.blog.model.Diary;
import com.clyde.blog.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author clyde
 */
@RestController
@RequestMapping("/diary")
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    //根据页数条数返回内容
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<Diary>> getListByIndexPages(@PathVariable("index") Integer index, @PathVariable("size") Integer size, Boolean isLogin) {
        IPage<Diary> iPage = new Page<>(index, size);
        if (isLogin != null && isLogin) {
            IPage<Diary> page = diaryService.page(iPage);
            return CommonResult.success(page);
        } else {
            IPage<Diary> page = diaryService.getPublicDiary(iPage);
            return CommonResult.success(page);
        }
    }

    //根据id返回博客内容
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<Diary> getDiary(@PathVariable("id") Integer id) {
        Diary diary = diaryService.getById(id);
        return CommonResult.success(diary);
    }

    //添加或更新日志
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateDiary(@RequestBody Diary diary) {
        if (diary.getId() == null) {
            if (diary.getCreatedTime() == null) {
                diary.setCreatedTime(new Date());
            }
            diaryService.save(diary);
        } else {
            diaryService.updateById(diary);
        }
    }

    //更新日志私密（开关）
    @RequestMapping(value = "/updatehidden", method = RequestMethod.POST)
    public CommonResult updateDiaryHidden(@RequestParam("id") Integer id, @RequestParam("hidden") Boolean hidden) {
        boolean result = diaryService.updateHiddenById(id, hidden);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //删除日志
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void deleteDiary(Integer id) {
        diaryService.removeById(id);
    }
}
