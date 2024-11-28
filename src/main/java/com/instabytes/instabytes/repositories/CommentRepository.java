package com.instabytes.instabytes.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.instabytes.instabytes.entities.Comment;

public interface CommentRepository extends MongoRepository< Comment, String>{
    
}
