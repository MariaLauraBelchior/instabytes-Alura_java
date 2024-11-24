package com.instabytes.instabytes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.instabytes.instabytes.dto.PostDTO;
import com.instabytes.instabytes.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
