package com.blossom.site.base.util.list;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/23 11:35
 */
public class Data {

    private Long id ;
    private Long courseId ;
    private String content ;

    public Long getId() {
        return id;
    }

    public Data setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Data setCourseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Data setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", content='" + content + '\'' +
                '}';
    }
}
