package com.instabytes.instabytes.servicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.instabytes.instabytes.dto.PostDTO;
import com.instabytes.instabytes.services.PostService;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    void testCreateAndFindAll() {
        PostDTO dto = new PostDTO();
        dto.setDescription("Post Teste");
        dto.setImgURL("test-image.jpg");

        PostDTO savedPost = postService.create(dto);

        assertNotNull(savedPost.getId());
        assertEquals("Post Teste", savedPost.getDescription());
    }
    
}
