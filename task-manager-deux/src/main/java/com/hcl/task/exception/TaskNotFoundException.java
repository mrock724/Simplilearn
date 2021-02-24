package com.hcl.task.exception;

public class TaskNotFoundException extends RuntimeException{
	public TaskNotFoundException(Integer id) {
		super("Could not find task " + id);
	}
}
