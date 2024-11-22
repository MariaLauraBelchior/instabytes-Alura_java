package com.instabytes.instabytes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.instabytes.instabytes.services.PostService;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/posts")
public class PostController {
    
    private PostService postService;


}
