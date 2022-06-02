package com.clyde.blog;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clyde.blog.dao.ArchitectureDAO;
import com.clyde.blog.dao.ArchitectureFeatureDAO;
import com.clyde.blog.dao.BlogDAO;
import com.clyde.blog.dao.UserDAO;
import com.clyde.blog.model.Architecture;
import com.clyde.blog.model.ArchitectureFeature;
import com.clyde.blog.model.Blog;
import com.clyde.blog.model.User;
import com.clyde.blog.service.ArchitectureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CodeBlogApplicationTests {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BlogDAO blogDAO;
    @Autowired
    private ArchitectureDAO architectureDAO;
    @Autowired
    private ArchitectureService architectureService;
    @Autowired
    private ArchitectureFeatureDAO architectureFeatureDAO;

    @Test
    void contextLoads() {
    }
}
