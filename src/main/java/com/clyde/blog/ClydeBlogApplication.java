package com.clyde.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//加载
@MapperScan("com.clyde.blog.dao")
@SpringBootApplication
public class ClydeBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClydeBlogApplication.class, args);
    }
}
