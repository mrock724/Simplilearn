package com.example.feedback.model;

import javax.persistence.*;

@Table(name = "feedback")
@Entity
public class Feedback {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	public void setId(Integer id) {
        this.id = id;
    }
	public Integer getId() {
        return id;
    }
    
	int rating;
	public void setRating(int rating) {
        this.rating = rating;
    }
	public Integer getRating() {
        return rating;
    }
    
	String user;
	public void setUser(String user) {
        this.user = user;
    }
	public String getUser() {
        return user;
    }
    
	String comment;
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getComment() {
        return comment;
    }

}
