package com.blossom.site.author.entity;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 权限实体类
 * @time 2017/3/25 21:33
 */
public class AuthorDo implements Serializable{


    private static final long serialVersionUID = -7939297628382770842L;

    private Integer authorId;
    private Integer parentAuthorId;
    private String authorName;
    private String authorDescription;
    private String authorUrl;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getParentAuthorId() {
        return parentAuthorId;
    }

    public void setParentAuthorId(Integer parentAuthorId) {
        this.parentAuthorId = parentAuthorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    @Override
    public String toString() {
        return "AuthorDo{" +
                "authorId=" + authorId +
                ", parentAuthorId=" + parentAuthorId +
                ", authorName='" + authorName + '\'' +
                ", authorDescription='" + authorDescription + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                '}';
    }
}
