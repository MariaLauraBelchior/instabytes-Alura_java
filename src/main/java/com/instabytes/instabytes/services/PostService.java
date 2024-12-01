package com.instabytes.instabytes.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instabytes.instabytes.dto.CommentDTO;
import com.instabytes.instabytes.dto.PostDTO;
import com.instabytes.instabytes.entities.Comment;
import com.instabytes.instabytes.entities.Post;
import com.instabytes.instabytes.repositories.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;


    public PostDTO findById(String id) {
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

    public PostDTO update(String id, PostDTO dto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        BeanUtils.copyProperties(dto, post, "id");
        post = postRepository.save(post);
        return new PostDTO(post);
    }

    public void delete(String id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }

    public CommentDTO addComment(String postId, CommentDTO commentDTO) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    
        Comment comment = new Comment();
        comment.setId(UUID.randomUUID().toString()); // Gerar ID único
        comment.setText(commentDTO.getText());
        comment.setAuthor(commentDTO.getAuthor());
    
        post.getComments().add(comment);
        postRepository.save(post);
    
        commentDTO.setId(comment.getId());
        return commentDTO;
    }

    public List<CommentDTO> getComments(String postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    
        return post.getComments().stream()
                .map(comment -> {
                    CommentDTO dto = new CommentDTO();
                    dto.setId(comment.getId());
                    dto.setText(comment.getText());
                    dto.setAuthor(comment.getAuthor());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

}
