package com.clyde.blog.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author clyde
 */
@TableName(value = "t_blog", resultMap = "com.clyde.blog.dao.BlogDAO.blogMap")
public class Blog implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String body;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    private String keywords;
    private String description;
    private BlogCategory category;
    private User author;
    @TableField(exist = false)
    private String orderField;
    @TableField(exist = false)
    private String orderType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BlogCategory getCategory() {
        return category;
    }

    public void setCategory(BlogCategory category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderField() {
        if (orderField == null || "".equals(orderField)) {
            orderField = "created_time";
        }
        return orderField;
    }

    public String getOrderType() {
        if (orderType == null || "".equals(orderType)) {
            orderType = "desc";
        }
        return orderType;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
