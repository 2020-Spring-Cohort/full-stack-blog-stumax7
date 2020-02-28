package org.wcci.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
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
//    @Bean
//    public CategoryRepository categoryRepository(){
//        return new CategoryRepository() {
//            @Override
//            public Optional<Category> findByName(String categoryName) {
//                return Optional.empty();
//            }
//
//            @Override
//            public <S extends Category> S save(S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends Category> Iterable<S> saveAll(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public Optional<Category> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @Override
//            public Iterable<Category> findAll() {
//                return null;
//            }
//
//            @Override
//            public Iterable<Category> findAllById(Iterable<Long> longs) {
//                return null;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(Category entity) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends Category> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//        };
//    }
}
