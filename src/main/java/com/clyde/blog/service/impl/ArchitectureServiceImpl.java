package com.clyde.blog.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyde.blog.Utils.Utils;
import com.clyde.blog.dao.ArchitectureDAO;
import com.clyde.blog.model.Architecture;
import com.clyde.blog.model.ArchitectureFeature;
import com.clyde.blog.model.ArchitectureGuessDTO;
import com.clyde.blog.service.ArchitectureArchitectService;
import com.clyde.blog.service.ArchitectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author clyde
 */
@Service
public class ArchitectureServiceImpl extends ServiceImpl<ArchitectureDAO, Architecture> implements ArchitectureService {
    @Autowired
    private ArchitectureDAO architectureDAO;
    @Autowired
    private ArchitectureArchitectService architectureArchitectService;

    @Override
    public void updateArchitectureById(Architecture architecture) {
        architectureDAO.updateArchitectureById(architecture);
        architectureDAO.delFeaturesById(architecture.getId());
        architectureDAO.insertFeaturesById(architecture.getFeatures(), architecture.getId());
    }

    @Override
    public void addArchitecture(Architecture architecture) {
        //先在主表插入信息
        int id = architectureDAO.insertArchitecture(architecture);
        //如果特点不为空在中间表添加
        List<ArchitectureFeature> features = architecture.getFeatures();
        if (features.size() != 0) {
            architectureDAO.insertFeaturesById(features, id);
        }
    }

    @Override
    public void delArchitectureById(Integer id) {
        architectureDAO.deleteById(id);
        architectureDAO.delFeaturesById(id);
    }

    @Override
    public IPage<Architecture> getListByFilter(IPage<Architecture> iPage, Architecture architecture) {
        return architectureDAO.selectListByFilter(iPage, architecture);
    }

    @Override
    public List<ArchitectureGuessDTO> getRandomArchitecture(Integer count) {
        //获取所有建筑的数量
        int max = architectureDAO.selectCount();
        //题目数量
        int questionCount = count;
        //选项个数
        int optionNums = 3;
        //随机获得几个答案建筑
        Set<Integer> nums = Utils.createRandomNums(questionCount, 1, max);
        //创建答案对象
        List<ArchitectureGuessDTO> list = new ArrayList<>();
        for (Integer id : nums) {
            //获得答案
            Architecture architecture = architectureDAO.selectById(id);
            ArchitectureGuessDTO guess = new ArchitectureGuessDTO();
            //变量
            List<String> options;
            Set<Integer> errorNums;
            List<String> errorNames;
            guess.setPhoto(architecture.getPhoto());
            //随机选题0建筑1建筑师2国家
            Integer random = (int) Math.floor(3 * Math.random());
            guess.setType(random);
            switch (random) {
                //0建筑
                case 0:
                    //设置问题
                    guess.setQuestion("这是哪一个著名的建筑");
                    //设置选项
                    options = new ArrayList<>();
                    //随机获取3个错误答案
                    errorNums = Utils.createRandomNums(optionNums, 1, max);
                    errorNames = architectureDAO.getArchitectureNames(errorNums);
                    //循环前2个添加2个错误。如果值相同就加最后一个
                    for (int i = 0; i < optionNums - 1; i++) {
                        //如果错误选项运气不好放入了
                        if (errorNames.get(i).equals(architecture.getName())) {
                            options.add(errorNames.get(optionNums - 1));
                        } else {
                            options.add(errorNames.get(i));
                        }
                    }
                    //为正确答案随机放位置
                    random = (int) Math.floor((optionNums) * Math.random());
                    guess.setAnswer(random);
                    //放在这个random中
                    options.add(random, architecture.getName());
                    guess.setOptions(options);
                    break;
                //1建筑师
                case 1:
                    //设置问题
                    guess.setQuestion("该建筑是由哪位大师设计的？");
                    //设置选项
                    options = new ArrayList<>();
                    //随机获取3个错误答案
                    int maxArchitectNums = architectureArchitectService.getArchitectSum();
                    errorNums = Utils.createRandomNums(optionNums, 1, maxArchitectNums);
                    errorNames = architectureArchitectService.getArchitectNames(errorNums);
                    //循环前2个添加2个错误。如果值相同就加最后一个
                    for (int i = 0; i < optionNums - 1; i++) {
                        //如果错误选项运气不好放入了
                        if (errorNames.get(i).equals(architecture.getArchitect().getName())) {
                            options.add(errorNames.get(optionNums - 1));
                        } else {
                            options.add(errorNames.get(i));
                        }
                    }
                    //为正确答案随机放位置
                    random = (int) Math.floor((optionNums) * Math.random());
                    guess.setAnswer(random);
                    //放在这个random中
                    options.add(random, architecture.getArchitect().getName());
                    guess.setOptions(options);
                    break;
                //2国家
                case 2:
                    //设置问题
                    guess.setQuestion("该建筑坐落于哪个国家？");
                    //设置选项
                    options = new ArrayList<>();
                    //获得所有国家的集合
                    List<String> countries = architectureDAO.selectAllCountry();
                    //随机获取3个错误答案
                    errorNums = Utils.createRandomNums(optionNums, 1, countries.size());
                    //循环前2个添加2个错误。如果值相同就加最后一个
                    for (int i = 0; i < optionNums - 1; i++) {
                        //如果错误选项运气不好放入了
                        if (countries.get(i).equals(architecture.getCountry())) {
                            options.add(countries.get(optionNums - 1));
                        } else {
                            options.add(countries.get(i));
                        }
                    }
                    //为正确答案随机放位置
                    random = (int) Math.floor((optionNums) * Math.random());
                    guess.setAnswer(random);
                    //放在这个random中
                    options.add(random, architecture.getCountry());
                    guess.setOptions(options);
                    break;
            }
            //添加guess
            list.add(guess);
        }
        return list;
    }
}
