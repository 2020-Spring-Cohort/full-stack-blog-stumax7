package org.wcci.blog.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class HashTag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "hashTags")
    private Collection<Post> posts;

    public HashTag(String name){
        posts = new ArrayList<>();
        this.name = name;
    }

    public HashTag(){}

    public Long getId(){return id;}

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTag hashTag = (HashTag) o;
        return id.equals(hashTag.id) &&
                name.equals(hashTag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "HashTag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
