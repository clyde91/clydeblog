package com.clyde.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clyde.blog.model.ArchitectureArchitect;
import com.clyde.blog.model.ArchitectureFeature;

import java.util.List;

/**
 * @author clyde
 */
public interface ArchitectureFeatureService extends IService<ArchitectureFeature> {

    public List<ArchitectureFeature> getFeaturesByParentId(Integer parentId);
}
