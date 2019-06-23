package com.yuxuyi.lvyouzhinan.entity;

public class Article {
    private Integer id;
    private String title;
    private String area;
    private String image;
    private String content;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArea() {
        return area;
    }

    public String getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", area='" + area + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
