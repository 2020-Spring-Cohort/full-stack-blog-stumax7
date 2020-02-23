package org.wcci.blog.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repositories.AuthorRepository;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.storage.repositories.PostRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
        @Autowired
        private CategoryRepository categoryRepository;
        @Autowired
        private PostRepository postRepository;
        @Autowired
        private TestEntityManager entityManager;
        @Autowired
        private AuthorRepository authorRepository;

        @Test
        public void categoryShouldHaveAListOfPosts(){
            Category testCategory = new Category("Media");
            Author testAuthor = new Author("Hugo Brass");
            Post testPost = new Post("R.I.P. Pop Smoke", "What a tragedy!", testAuthor, testCategory);

            authorRepository.save(testAuthor);
            categoryRepository.save(testCategory);
            postRepository.save(testPost);

            entityManager.flush();
            entityManager.clear();

            Optional<Category> retrievedCategoryOptional = categoryRepository.findById(testCategory.getId());
            Category retrievedCategory = retrievedCategoryOptional.get();
            Post retrievedPost = postRepository.findById(testPost.getId()).get();

            assertThat(retrievedCategory.getPosts()).contains(testPost);
        }
    }
