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

    @ManyToMany
    private Collection<Hashtag> hashtags;

    @ManyToOne
    private Author postAuthor;

    public Post(Long id, String postTitle, String postBody, Author postAuthor, LocalDateTime publishDate, Category postCategory, Collection<Hashtag> hashtags) {
        this.id = id;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postAuthor = postAuthor;
        this.publishDate = publishDate;
        this.postCategory = postCategory;
        this.hashtags = hashtags;
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

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public Category getPostCategory() {
        return postCategory;
    }

    public Collection <Hashtag> getHashtags() {
        return hashtags;
    }
}

