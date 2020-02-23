package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.models.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository {
    Optional<Category> findByName(String categoryName);
}
