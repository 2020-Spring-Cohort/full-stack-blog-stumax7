package org.wcci.blog.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repositories.PostRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PostStorageJpaImplTest {
    private PostRepository postRepository;
    private PostStorage underTest;
    private Post testPost;

    @BeforeEach
    void setUp(){
        postRepository = mock(PostRepository.class);
        underTest = new PostStorageJpaImpl(postRepository);
        Category testCategory = new Category("Media");
        Author testAuthor = new Author("Hugo Brass");
        testPost = new Post();

    }

    @Test
    public void shouldFindPostById(){
        when(postRepository.findById(1L)).thenReturn(Optional.of(testPost));
        Post retrievedPost = underTest.findPostById(1L);
        assertThat(retrievedPost).isEqualTo(testPost);
    }

    @Test
    public void shouldStorePost(){
        underTest.store(testPost);
        verify(postRepository).save(testPost);
    }
}
