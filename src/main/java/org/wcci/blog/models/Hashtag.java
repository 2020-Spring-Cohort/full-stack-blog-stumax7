package org.wcci.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private Long id;

    private String hashtagName;

    @ManyToMany
    private Collection<Post> posts;

    public Hashtag(){}

    public Hashtag(String hashtagName, Collection<Post> posts){
        this.hashtagName = hashtagName;
        this.posts = posts;
    }

    public Long getId(){
        return id;
    }

    public String getHashtagName(){
        return hashtagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashtag hashtag = (Hashtag) o;

        if (id != null ? !id.equals(hashtag.id) : hashtag.id != null) return false;
        if (hashtagName != null ? !hashtagName.equals(hashtag.hashtagName) : hashtag.hashtagName != null) return false;
        return posts != null ? posts.equals(hashtag.posts) : hashtag.posts == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hashtagName != null ? hashtagName.hashCode() : 0);
        result = 31 * result + (posts != null ? posts.hashCode() : 0);
        return result;
    }
}
