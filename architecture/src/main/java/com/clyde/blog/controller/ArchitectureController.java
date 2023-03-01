package com.clyde.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.common.api.CommonResult;
import com.clyde.blog.model.Architecture;
import com.clyde.blog.model.ArchitectureArchitect;
import com.clyde.blog.model.ArchitectureGuessDTO;
import com.clyde.blog.service.ArchitectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author clyde
 */
@RestController
@RequestMapping("/architecture")
public class ArchitectureController {
    @Autowired
    private ArchitectureService architectureService;
    @Autowired
    private RedisService redisService;

    //分页返回全部建筑
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.GET)
    public CommonResult<IPage<Architecture>> getListByIndexPages(@PathVariable("index") Integer index, @PathVariable("size") Integer size) {
        IPage<Architecture> page;
//        //先在redis查是否存在数据
//        String data = redisService.get("architecture：" + index + ":" + size);
//        //如果存在。直接拉取。如果不存在。就从数据库获取。并且保存到redis中
//        if (data != null) {
//            //反序列化
//            Gson gson = new Gson();
//            Type type = new TypeToken<IPage<Architecture>>() {}.getType();
//            page = gson.fromJson(data, type);
//        }else
//        {
            IPage<Architecture> iPage = new Page<>(index, size);
            page = architectureService.page(iPage);
//            //序列化
//            Gson gson = new Gson();
//            String json = gson.toJson(page);
//            redisService.set("architecture：" + index + ":" + size, json);
//        }
        return CommonResult.success(page);
    }

    //分页返回全部建筑(带参数查询)
    @RequestMapping(value = "/{index}/{size}", method = RequestMethod.POST)
    public CommonResult<IPage<Architecture>> getListByIndexPagesFilter(@PathVariable("index") Integer index, @PathVariable("size") Integer size, @RequestBody Architecture architecture) {
        IPage<Architecture> iPage = new Page<>(index, size);
        IPage<Architecture> page = architectureService.getListByFilter(iPage, architecture);
        return CommonResult.success(page);
    }

    //根据id返回建筑内容
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<Architecture> getArchitectureById(@PathVariable("id") Integer id) {
        Architecture architecture = architectureService.getById(id);
        //如果建筑师为空。返回一个空建筑师
        if (architecture.getArchitect() == null) {
            ArchitectureArchitect architect = new ArchitectureArchitect();
            architecture.setArchitect(architect);
        }
        return CommonResult.success(architecture);
    }

    //更新或者添加建筑
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateArchitecture(@RequestBody Architecture architecture) {
        if (architecture.getId() == null) {
            architectureService.addArchitecture(architecture);
        } else {
            architectureService.updateArchitectureById(architecture);
        }
    }

    //删除建筑
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void delArchitectureById(Integer id) {
        architectureService.delArchitectureById(id);
    }

    //猜建筑游戏。返回12个建筑
    @RequestMapping(value = "/guest", method = RequestMethod.GET)
    public CommonResult<List<ArchitectureGuessDTO>> getArchitecturesRandomly(Integer count) {
        List<ArchitectureGuessDTO> list = architectureService.getRandomArchitecture(count);
        return CommonResult.success(list);
    }
//    //测试
//    @Autowired
//    private ArchitectureDAO architectureDAO;
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public CommonResult<IPage<Architecture>> test() {
//        IPage<Architecture> iPage = new Page<>(0, 2);
//        Architecture architecture =new Architecture();
//        architecture.setArchitect(new ArchitectureArchitect());
//        architecture.setCountry("日本");
//        IPage<Architecture> page = architectureDAO.selectListByFilter(iPage, architecture);
//        return CommonResult.success(page);
//    }
}
