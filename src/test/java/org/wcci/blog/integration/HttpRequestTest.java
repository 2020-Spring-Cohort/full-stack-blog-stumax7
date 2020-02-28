package org.wcci.blog.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @MockBean
    private CategoryStorage categoryStorage;
    private Category testCategory;

    @BeforeEach
    public void testClassSetup() {
        testCategory = new Category("Media");
    }

    @Test
    public void categoriesEndPointReturnsOK() {
        when(categoryStorage.findAllCategories()).thenReturn(Collections.singletonList(testCategory));
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/categories", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void specificEndPointReturnsOK() {
        when(categoryStorage.findCategoryByName(anyString())).thenReturn(testCategory);
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/categories/" + testCategory.getName(), String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
