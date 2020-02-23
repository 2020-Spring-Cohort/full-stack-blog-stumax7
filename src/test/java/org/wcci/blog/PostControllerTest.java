package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.PostController;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.PostStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PostControllerTest {
    private PostController underTest;
    private Model model;
    private PostStorage mockStorage;
    private Post testPost;

    @BeforeEach
    void setUp(){
        mockStorage = mock(PostStorage.class);
        underTest = new PostController(mockStorage);
        model = mock(Model.class);
        Category testCategory = new Category("Media");
        Author testAuthor = new Author("Hugo Brass");
        testPost = new Post();
        when(mockStorage.findPostById(1L)).thenReturn(testPost);
    }
    @Test
    public void displayPostReturnsTemplate(){
        String result = underTest.displayPost(1L, model);
        assertThat(result).isEqualTo("postView");
    }
    @Test
    public void displayBookInteractsWithDependenciesCorrectly(){
        underTest.displayPost(1L, model);
        verify(mockStorage).findPostById(1L);
        verify(model).addAttribute("post", testPost);
    }
    @Test
    public void displayPostMappingIsCorrect() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/posts/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("postView"))
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attribute("post", testPost));
    }
}
