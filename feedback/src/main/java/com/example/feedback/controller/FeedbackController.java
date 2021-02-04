package com.example.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback.model.Feedback;
import com.example.feedback.repo.FeedbackRepo;

@RestController
public class FeedbackController {
	@Autowired
	private FeedbackRepo repo;
	
	@GetMapping("/")
	public String showService() {
		return "Feedbacker";
	}
	
	@GetMapping("/submit/{id}")
	public Feedback showFeedbackById(@PathVariable Integer id) {
		//to do :)
		return repo.findById(id).get();
	}
	@PostMapping("/submit")
	public Feedback addFeedback(@RequestBody Feedback newFeedback) {
		//to do :)
		return repo.save(newFeedback);
	}
}
