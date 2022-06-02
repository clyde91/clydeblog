package com.clyde.blog.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.OssPolicyResult;
import com.clyde.blog.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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
        System.out.println("api = " + api);
        OssPolicyResult result = ossService.policy(api);
        System.out.println("result = " + result);
        return CommonResult.success(result);
    }
}
