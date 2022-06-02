package com.clyde.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.clyde.blog.dao")
@SpringBootApplication
public class CodeBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeBlogApplication.class, args);
    }

}
