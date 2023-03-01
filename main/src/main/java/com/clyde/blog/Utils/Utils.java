package com.clyde.blog.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 创建随机数
 * @author clyde
 */
public class Utils {

    public static Set<Integer> createRandomNums(Integer count, Integer min,Integer max){
        Map<Integer, Integer> map = new HashMap<>();
        while (map.size() < count) {
            Integer random = (int) Math.floor((max-min+1) * Math.random())+min;
            map.put(random, random);
        }

        return map.keySet();
    }
//    public static List<Integer> createRandomNums(Integer count, Integer max){
//        Map<Integer, Integer> map = new HashMap<>();
//        while (map.size() < count) {
//            Integer random = (int) Math.floor(max * Math.random());
//            map.put(random, random);
//        }
//        List<Integer> list=new ArrayList<>();
//        for (Integer integer : map.keySet()) {
//            list.add(integer);
//        }
//        return list;
//    }
}
