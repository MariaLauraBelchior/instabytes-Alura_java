package com.instabytes.instabytes.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.instabytes.instabytes.entities.Post;

public class PostDTO {
    
    private String id;
    private String description;
    private String imgURL;
    
    private List<CommentDTO> comments;


    public PostDTO() {
    }

    public PostDTO(Post entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
    
}
