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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (postTitle != null ? !postTitle.equals(post.postTitle) : post.postTitle != null) return false;
        if (postBody != null ? !postBody.equals(post.postBody) : post.postBody != null) return false;
        if (publishDate != null ? !publishDate.equals(post.publishDate) : post.publishDate != null) return false;
        if (postCategory != null ? !postCategory.equals(post.postCategory) : post.postCategory != null) return false;
        return postAuthor != null ? postAuthor.equals(post.postAuthor) : post.postAuthor == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (postTitle != null ? postTitle.hashCode() : 0);
        result = 31 * result + (postBody != null ? postBody.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (postCategory != null ? postCategory.hashCode() : 0);
        result = 31 * result + (postAuthor != null ? postAuthor.hashCode() : 0);
        return result;
    }
}

