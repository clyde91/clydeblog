package com.clyde.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author clyde
 */
//加载
@MapperScan("com.clyde.blog.dao")
@SpringBootApplication
@EnableCaching
public class ArchitectureApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArchitectureApplication.class, args);
    }
}