package com.instabytes.instabytes.config;

import org.springframework.boot.CommandLineRunner;

import com.instabytes.instabytes.entities.Post;
import com.instabytes.instabytes.repositories.PostRepository;

public class MongoDBSeeder {
    
    CommandLineRunner runner(PostRepository postRepository) {
        return args -> {
            Post post1 = new Post();
            post1.setDescription("Post de teste 1");
            post1.setImgURL("lontras/imag1.jpg");

            Post post2 = new Post();
            post2.setDescription("Post de teste 2");
            post2.setImgURL("gatinhos/imag2.jpg");

            postRepository.save(post1);
            postRepository.save(post2);

            System.out.println("Banco de dados populado com posts de teste.");
        };
    }
}
