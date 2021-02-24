package com.hcl.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.task.exception.TaskNotFoundException;
import com.hcl.task.model.Task;
import com.hcl.task.repo.TaskRepo;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	
	public Iterable<Task> getAllTasks(){
		return taskRepo.findAll();
	}
	
	// return Task instead of Optional<Task>
	public Optional<Task> getTaskById(Integer id) {
		Optional<Task> foundTask = taskRepo.findById(id);
		if(!foundTask.isPresent()) {
			throw new TaskNotFoundException(id);
		}
		//return taskRepo.findById(id);
		return foundTask;
	}
	
	public Task addTask(Task task) {
		return taskRepo.save(task);
	}
	
	public void deleteTask(Task task) {
		taskRepo.delete(task);
	}
}
