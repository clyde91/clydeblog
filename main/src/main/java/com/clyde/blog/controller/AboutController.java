package com.clyde.blog.controller;

import com.clyde.blog.common.CommonResult;
import com.clyde.blog.model.About;
import com.clyde.blog.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author clyde
 */
@RestController
@RequestMapping("/about")
public class AboutController {
    @Autowired
    private AboutService aboutService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult<List<About>> getList() {
        List<About> list = aboutService.list();
        return CommonResult.success(list);
    }


}
