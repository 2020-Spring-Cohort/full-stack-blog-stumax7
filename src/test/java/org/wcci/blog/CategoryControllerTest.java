package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.CategoryController;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoryControllerTest {

    private MockMvc mockMvc;
    private CategoryController underTest;
    private CategoryStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp(){
        mockModel = mock(Model.class);
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoryController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldReturnViewWithOneCategory(){
        Category testCategory = new Category("Media");
        when(mockStorage.findCategoryByName("Media")).thenReturn(testCategory);
        underTest.displaySingleCategory("Media", mockModel);
        verify(mockStorage).findCategoryByName("Media");
        verify(mockModel).addAttribute("category", testCategory);
    }

    @Test
    public void shouldReturnViewNamedCategoryViewWhenDisplaySingleCategoryIsCalled(){
        String viewName = underTest.displaySingleCategory("Media", mockModel);
        assertThat(viewName).isEqualTo("categoryView");
    }
    @Test
    public void shouldGoToIndividualEndPoint() throws Exception{
        Category testCategory = new Category("Media");
        when(mockStorage.findCategoryByName("Media")).thenReturn(testCategory);
        mockMvc.perform(get("/categories/Media"))
                .andExpect(status().isOk())
                .andExpect(view().name("categoryView"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("category", testCategory));

    }
    @Test
    public void categoriesEndPointDisplaysAllCategories() throws Exception {
        Category testCategory = new Category("Media");
        List<Category> categoryCollection = Collections.singletonList(testCategory);
        when(mockStorage.findAllCategories()).thenReturn(categoryCollection);
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categoriesView"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categoryCollection));
    }
}
