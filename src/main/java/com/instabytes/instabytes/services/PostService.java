package com.instabytes.instabytes.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instabytes.instabytes.dto.PostDTO;
import com.instabytes.instabytes.entities.Post;
import com.instabytes.instabytes.repositories.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public PostDTO findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return new PostDTO(post);
    }

}
