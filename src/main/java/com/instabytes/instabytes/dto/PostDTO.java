package com.instabytes.instabytes.dto;

import org.springframework.beans.BeanUtils;

import com.instabytes.instabytes.entities.Post;

public class PostDTO {
    
    private long id;
    private String description;
    private String image;
    
    public PostDTO() {
    }

    public PostDTO(Post entity) {
        BeanUtils.copyProperties(entity, this);
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

    
}
