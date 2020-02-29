package org.wcci.blog.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    private Set<HashTag> hashTags;

    @ManyToOne
    private Author postAuthor;

    public Post(String postTitle, String postBody, Author postAuthor, Category postCategory) {
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postAuthor = postAuthor;
        this.postCategory = postCategory;
        this.hashTags = new HashSet<>();
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

    public Collection<HashTag> getHashTags() {
        return hashTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(postTitle, post.postTitle) &&
                Objects.equals(postBody, post.postBody) &&
                Objects.equals(publishDate, post.publishDate) &&
                Objects.equals(postCategory, post.postCategory) &&
                Objects.equals(hashTags, post.hashTags) &&
                Objects.equals(postAuthor, post.postAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postTitle, postBody, publishDate, postCategory, hashTags, postAuthor);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postTitle='" + postTitle + '\'' +
                ", postBody='" + postBody + '\'' +
                ", publishDate=" + publishDate +
                ", postCategory=" + postCategory +
                ", hashTags=" + hashTags +
                ", postAuthor=" + postAuthor +
                '}';
    }
    public void addHashTag(HashTag hashTagToAdd){
        hashTags.add(hashTagToAdd);
    }
}

