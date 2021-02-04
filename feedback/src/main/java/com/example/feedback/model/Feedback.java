package com.example.feedback.model;

import javax.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    int id;
    int rating;
    String user;
    String comment;
    
    public void setId(Integer id) {
        this.id = id;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setcomment(String comment) {
        this.comment = comment;
    }
    
    public Integer getId() {
        return id;
    }
    public Integer getRating() {
        return rating;
    }
    public String getUser() {
        return user;
    }
    public String getcomment() {
        return comment;
    }

}
