package com.hcl.task.repo;

import org.springframework.data.repository.CrudRepository;

import com.hcl.task.model.Task;

public interface TaskRepo extends CrudRepository<Task,Integer>{

}
