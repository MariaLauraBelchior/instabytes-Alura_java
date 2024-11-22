package com.instabytes.instabytes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.instabytes.instabytes.repositories.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    
}
