package com.clyde.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * @author clyde
 */
@TableName(value = "t_architecture", resultMap = "com.clyde.blog.dao.ArchitectureDAO.architectureMap")
public class Architecture implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private ArchitectureArchitect architect;
    private String country;
    private String photo;
    private List<ArchitectureFeature> features;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArchitectureArchitect getArchitect() {
        return architect;
    }

    public void setArchitect(ArchitectureArchitect architect) {
        this.architect = architect;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<ArchitectureFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<ArchitectureFeature> features) {
        this.features = features;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderField() {
//        if (orderField == null || "".equals(orderField)) {
//            orderField = "id";
//        }
        return orderField;
    }

    public String getOrderType() {
//        if (orderType == null || "".equals(orderType)) {
//            orderType = "desc";
//        }
        return orderType;
    }

    @Override
    public String toString() {
        return "Architecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", architect=" + architect +
                ", country='" + country + '\'' +
                ", photo='" + photo + '\'' +
                ", features=" + features +
                ", orderField='" + orderField + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
