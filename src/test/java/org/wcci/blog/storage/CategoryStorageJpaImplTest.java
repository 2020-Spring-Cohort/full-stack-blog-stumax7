package org.wcci.blog.storage;

import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.repositories.CategoryRepository;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStorageJpaImplTest {
    @Test
    public void shouldFindAllCategories(){
        CategoryRepository mockCategoryRepository = mock(CategoryRepository.class);
        Category testCategory = new Category("Media");
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockCategoryRepository);
        when(mockCategoryRepository.findAll()).thenReturn(Collections.singletonList(testCategory));
        underTest.store(testCategory);
        verify(mockCategoryRepository).save(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);
    }

    @Test
    public void shouldRetrieveSingleCategoryByName(){
        CategoryRepository mockCategoryRepository = mock(CategoryRepository.class);
        Category testCategory1 = new Category("Media");
        Category testCategory2 = new Category("News and Politics");
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockCategoryRepository);
        underTest.store(testCategory1);
        underTest.store(testCategory2);
        Optional<Category> testCategory1Optional = Optional.of(testCategory1);
        when(mockCategoryRepository.findByName("Media")).thenReturn(testCategory1Optional);
        Optional<Category> testCategory2Optional = Optional.of(testCategory2);
        when(mockCategoryRepository.findByName("News and Politics")).thenReturn(testCategory2Optional);
        Category retrievedCategory1 = underTest.findCategoryByName("Media");
        Category retrievedCategory2 = underTest.findCategoryByName("News and Politics");
        assertThat(retrievedCategory1).isEqualTo(testCategory1);
        assertThat(retrievedCategory2).isEqualTo(testCategory2);
    }
}
