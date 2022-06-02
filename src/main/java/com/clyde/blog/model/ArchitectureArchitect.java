package com.clyde.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author clyde
 */
@TableName(value = "t_architecture_architect",resultMap = "com.clyde.blog.dao.ArchitectureArchitectDAO.architectureArchitectMap")
public class ArchitectureArchitect {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String country;
    private String avatar;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "ArchitectureArchitect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
