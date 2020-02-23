package org.wcci.blog.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String postTitle;
    private String postBody;
    private LocalDateTime publishDate;

    @ManyToOne
    private Category postCategory;

//    @ManyToMany
//    private Collection<Hashtag> hashtags;

    @ManyToOne
    private Author postAuthor;

    public Post(String postTitle, String postBody, Author postAuthor, Category postCategory) {
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postAuthor = postAuthor;
        this.postCategory = postCategory;
    }

    public Post(){}

    public Long getId(){
        return id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public Author getPostAuthor() {
        return postAuthor;
    }

    public Category getPostCategory() {
        return postCategory;
    }
}

