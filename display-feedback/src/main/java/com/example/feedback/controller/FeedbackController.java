package com.example.feedback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback.model.Feedback;
import com.example.feedback.repo.FeedbackRepo;

@RestController
public class FeedbackController {
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	
	@Autowired
	private FeedbackRepo repo;
	
	@GetMapping("/")
	public String showService() {
		Iterable<Feedback> feedback = repo.findAll();
        String output = "<h2>All users</h2>";
        for (Feedback fb: feedback) {
        	output += "<p>ID: " 		+ fb.getId() 		+ "</p>";
        	output += "<p>Rating: " 	+ fb.getRating() 	+ "</p>";
        	output += "<p>User: " 		+ fb.getUser() 		+ "</p>";
        	output += "<p>Comment: " 	+ fb.getComment() 	+ "</p>";
        }
        return output;
	}
	
	@GetMapping("/feedback/{id}")
	public Feedback showFeedbackById(@PathVariable Integer id) {
		if(id == null) {
			logger.error("URL did not contain an ID number");
			throw new RuntimeException("No ID number was specified");
		} else {
			Iterable<Feedback> savedFb = repo.findAll();
			for(Feedback f: savedFb) {
				if(f.getId().equals(id)) {
					return repo.findById(id).get();
				}
			}
		}
		logger.error("Invalid ID number given");
		throw new RuntimeException("There is no feedback at this ID number");
	}
	
	@GetMapping("/submit")
	public String showAdd() {
		String output = "<form action='' method='POST'>";
		output += "<h2>Enter your feedback below! ^_^</h2>";
        output += "Rating [1-10]: <input name='rating' type='text' /><br />";
        output += "User: <input name='user' type='text' /><br />";
        output += "Comment: <input name='comment' type='text' /><br />";
        output += "<input type='submit' />";
        output += "</form>";
        return output;
	}
	@PostMapping("/submit")
	public Feedback addFeedback(@ModelAttribute Feedback newFb) {
		if(newFb == null || newFb.getUser() == null || newFb.getComment() == null) {
            logger.error("User and/or comment left blank");
            throw new RuntimeException("Name field cannot be left blank");
		} else if(newFb.getRating() < 1 || newFb.getRating() > 5) {
			logger.error("Invalid rating given");
            throw new RuntimeException("Rating was not a valid number, must be 1-10");
		}
		logger.info("New feedback was created");
		return repo.save(newFb);
	}
}
