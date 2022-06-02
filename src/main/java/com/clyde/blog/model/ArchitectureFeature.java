package com.clyde.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author clyde
 */
@TableName(value = "t_architecture_feature",resultMap = "com.clyde.blog.dao.ArchitectureFeatureDAO.architectureFeatureMap")
public class ArchitectureFeature implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "ArchitectureFeature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
