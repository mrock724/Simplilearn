package com.example.feedback.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.feedback.model.Feedback;

public interface FeedbackRepo extends CrudRepository<Feedback, Integer> {
	//
}
