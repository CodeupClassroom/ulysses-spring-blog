package com.codeup.blog.relationships;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id @GeneratedValue
    private long id;

    String name;

    @ManyToMany
    @JoinTable
    List<Ad> ads;
}
