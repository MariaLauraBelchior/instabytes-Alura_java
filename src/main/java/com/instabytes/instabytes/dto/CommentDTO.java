package com.instabytes.instabytes.dto;

import org.springframework.beans.BeanUtils;

import com.instabytes.instabytes.entities.Comment;

public class CommentDTO {
    
    private String id;
    private String text;
    private String author;
    
    public CommentDTO() {
    }

    public CommentDTO(Comment entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    
}
