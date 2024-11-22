package com.instabytes.instabytes.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.instabytes.instabytes.entities.Post;

public interface PostRepository extends MongoRepository< Post, Long>{
    
}
