package com.clyde.blog.common.api;


import com.clyde.blog.Utils.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @author clyde
 */

public class RedisCache implements Cache {
    private String id;

    public RedisCache(String id) {
        this.id = id;
    }

    //返回那个namespace
    @Override
    public String getId() {
        return this.id;
    }

    //put存放缓存的方法
    @Override
    public void putObject(Object key, Object value) {
        System.out.println("添加缓存key: " + key + " value:" + value);
        getRedisTemplate().opsForHash().put(id, key.toString(), value);
    }


    // get将缓存中的数据取出
    @Override
    public Object getObject(Object key) {
        System.out.println("获取缓存: " + key);
        return getRedisTemplate().opsForHash().get(id, key.toString());
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    // 当发送增删改操作时clear方法被调用
    @Override
    public void clear() {
        System.out.println("清空缓存");
        getRedisTemplate().delete(id);
    }

    // 缓存中有多少条缓存
    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id).intValue();
    }

    //获取redisTemplate 由于redisCache没有注解成component，不在spring容器中。使用不了@Autowired，所以redisTemplate需要手动获得
    private RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}