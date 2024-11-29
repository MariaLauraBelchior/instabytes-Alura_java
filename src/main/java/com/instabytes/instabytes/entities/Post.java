package com.instabytes.instabytes.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String description;
    private String imgURL;

    private List<Comment> comments = new ArrayList<>();

    public Post(){
    }
    
    public Post(String id, String description, String imgURL, Comment comments) {
        this.id = id;
        this.description = description;
        this.imgURL = imgURL;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }  

    

    
}
