package org.wcci.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String authorName;

    @OneToMany(mappedBy = "authors")
    private Collection<Post> posts;

    public Author(String authorName){
        this.authorName = authorName;
    }

    public Author(){}

    public Long getId(){
        return id;
    }

    public String getAuthorName(){
        return authorName;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != null ? !id.equals(author.id) : author.id != null) return false;
        if (authorName != null ? !authorName.equals(author.authorName) : author.authorName != null) return false;
        return posts != null ? posts.equals(author.posts) : author.posts == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (posts != null ? posts.hashCode() : 0);
        return result;
    }
}
