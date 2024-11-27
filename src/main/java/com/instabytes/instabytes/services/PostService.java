package com.instabytes.instabytes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
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

    public List<PostDTO> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());
    }

    public PostDTO create(PostDTO dto) {
        Post post = new Post();
        BeanUtils.copyProperties(dto, post);
        post = postRepository.save(post);
        return new PostDTO(post);
    }

    public PostDTO update(Long id, PostDTO dto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        BeanUtils.copyProperties(dto, post, "id");
        post = postRepository.save(post);
        return new PostDTO(post);
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }
}
