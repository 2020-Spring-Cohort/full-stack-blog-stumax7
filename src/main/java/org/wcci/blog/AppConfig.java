package org.wcci.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;

import java.util.Collection;

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

}
