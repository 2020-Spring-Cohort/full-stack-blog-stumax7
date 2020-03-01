package org.wcci.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repositories.CategoryRepository;

import java.util.Collection;
import java.util.Optional;

@Configuration
public class AppConfig{
    @Bean
    public CategoryStorage categoryStorage(){
        return new CategoryStorage() {
            @Override
            public Collection<Category> findAllCategories() {
                return null;
            }

            @Override
            public void store(Category category) {

            }

            @Override
            public Category findCategoryByName(String categoryName) {
                return null;
            }
        };
    }
    @Bean
    public PostStorage postStorage(){
        return new PostStorage() {
            @Override
            public Post findPostById(Long id) {
                return null;
            }

            @Override
            public void store(Post postToStore) {

            }
        };
    }
    @Bean
    public AuthorStorage authorStorage(){
        return new AuthorStorage() {
            @Override
            public void store(Author authorToStore) {

            }
        };
    }
}
