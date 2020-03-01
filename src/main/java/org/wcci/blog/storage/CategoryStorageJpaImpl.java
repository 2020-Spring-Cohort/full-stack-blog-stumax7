package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.repositories.CategoryRepository;

import java.util.Collection;

@Service
public class CategoryStorageJpaImpl implements CategoryStorage{
    private CategoryRepository categoryRepository;

    public CategoryStorageJpaImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Collection<Category> findAllCategories(){
        return (Collection<Category>) categoryRepository.findAll();
    }

    @Override
    public void store(Category category){
        categoryRepository.save(category);
    }

    @Override
    public Category findCategoryByName(String categoryName){
        return categoryRepository.findByName(categoryName).get();
    }
}
