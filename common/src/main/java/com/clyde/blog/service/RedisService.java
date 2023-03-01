package com.clyde.blog.service;

/**
 * redis操作接口
 *
 * @author clyde
 */
public interface RedisService {
    String get(String key);
    void set(String key, String value);
}
