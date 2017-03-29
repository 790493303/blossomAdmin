package com.blossom.site.base.utils.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Blossom
 * @Description 列表树形显示实体
 * @time 2017/3/23 13:36
 */
public class TreeEntity implements Serializable{


    private static final long serialVersionUID = -5177295018738642510L;
    private Integer id;
    private Integer parentId;
    private String name;
    private String parentName;
    private String resKey;
    private String resUrl;
    private Integer level;
    private String type;
    private String description;
    private List<TreeEntity> children = new ArrayList<TreeEntity>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TreeEntity> getChildren() {
        return children;
    }

    public void setChildren(List<TreeEntity> children) {
        this.children = children;
    }
}
