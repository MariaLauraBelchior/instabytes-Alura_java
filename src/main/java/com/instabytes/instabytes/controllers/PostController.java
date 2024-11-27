package com.instabytes.instabytes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.instabytes.instabytes.dto.PostDTO;
import com.instabytes.instabytes.services.PostService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    private PostService postService;


    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable Long id) {
        PostDTO dto = postService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll() {
        List<PostDTO> list = postService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<PostDTO> create(@RequestBody PostDTO dto) {
        PostDTO newPost = postService.create(dto);
        return ResponseEntity.ok(newPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable Long id, @RequestBody PostDTO dto) {
        PostDTO updatedPost = postService.update(id, dto);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
