package com.instabytes.instabytes;

import java.util.ArrayList;
import java.util.List;

public class Post {
    
    private long id;
    private String description;
    private String image;
    
    public Post(long id, String description, String image) {
        this.id = id;
        this.description = description;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Uma foto teste", "https://placecats.com/millie/300/150"));
        posts.add(new Post(2, "Gato fazendo yoga", "https://placecats.com/millie/300/150"));
        posts.add(new Post(3, "Gato fazendo panqueca", "https://placecats.com/millie/300/150"));

        
        for (Post post : posts) {
            System.out.println(post.getDescription());
        }
    }
    
}
