package com.instabytes.instabytes.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.instabytes.instabytes.entities.User;

public interface UserRepository extends MongoRepository <User, String>{

    
} 
