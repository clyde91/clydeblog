package com.clyde.blog.controller;

import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.OssPolicyResult;
import com.clyde.blog.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clyde
 */
@RestController
public class OSSController {
    @Autowired
    OssService ossService;
    @CrossOrigin
    @RequestMapping("oss/policy")
    public CommonResult<OssPolicyResult> policy(String api){
        OssPolicyResult result = ossService.policy(api);
        return CommonResult.success(result);
    }
}
