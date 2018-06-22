package com.codeup.blog.relationships;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ads")
public class Ad {
    @Id @GeneratedValue
    private long id;

    private String title;
    private String description;

    public Ad() {}

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToMany(mappedBy = "ads")
    private List<Category> categoryList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
