package com.hcl.task.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.task.model.Task;
import com.hcl.task.model.User;
import com.hcl.task.service.TaskService;
import com.hcl.task.service.UserService;

@Controller
@SessionAttributes("name")
public class TaskController {
	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/create-task")
	public ModelAndView showCreate() {
		ModelAndView modelAndView = new ModelAndView();
		Task task = new Task();
        modelAndView.addObject("task", task);
		modelAndView.setViewName("create-task");
        return modelAndView;
	}
	
	@PostMapping(value = "/create-task")
    public ModelAndView createTask(@Valid Task task, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUserName(task.getUser_task());
        if (userExists == null) {
            bindingResult
                    .rejectValue("user_task", "error.task",
                            "There is no user registered with the user name provided");
        }
        if (task.getStart() == null) {
            bindingResult
                    .rejectValue("start", "error.task",
                            "Start date cannot be blank");
        }
        if (task.getEnd() == null) {
            bindingResult
                    .rejectValue("end", "error.task",
                            "End date cannot be blank");
        }
        if (task.getEnd().compareTo(task.getStart()) < 0) {
            bindingResult
                    .rejectValue("end", "error.task",
                            "End date cannot occur before start date");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("create-task");
        } else {
            taskService.addTask(task);
            modelAndView.addObject("successMessage",
            		"Task " + task.getName() + " has been added successfully for " + task.getUser_task());
            modelAndView.addObject("task", new Task());
            modelAndView.setViewName("create-task");

        }
        return modelAndView;
    }
	
	@GetMapping(value="/delete-task")
	public ModelAndView showDelete() {
		ModelAndView modelAndView = new ModelAndView();
		Task task = new Task();
        modelAndView.addObject("task", task);
        modelAndView.setViewName("delete-task");
        return modelAndView;
	}
	
	@PostMapping(value = "/delete-task")
    public ModelAndView deleteTask(Task task, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Task> taskExists = taskService.getTaskById(task.getId());
        if (taskExists == null) {
            bindingResult
                    .rejectValue("id", "error.task",
                            "There is no task with the ID provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("delete-task");
        } else {
            taskService.deleteTask(task);
            modelAndView.addObject("successMessage",
            		"Task at ID number " + task.getId() + " has been deleted successfully");
            modelAndView.addObject("task", new Task());
            modelAndView.setViewName("delete-task");

        }
        return modelAndView;
    }
	/*
	@GetMapping(value="/display-tasks")
	public ModelAndView showDisplay() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("display-tasks");
        return modelAndView;
	}
	*/
	@RequestMapping(value="/display-tasks",method=RequestMethod.GET)
	public String showDisplay(ModelMap model) {
		model.put("tasks", taskService.getAllTasks());
		return "display-tasks";
	}
	
	@GetMapping(value="/update-task")
	public ModelAndView showUpdate() {
		ModelAndView modelAndView = new ModelAndView();
		Task task = new Task();
        modelAndView.addObject("task", task);
        modelAndView.setViewName("update-task");
        return modelAndView;
	}
	
	@PostMapping(value = "/update-task")
    public ModelAndView updateTask(@Valid Task task, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUserName(task.getUser_task());
        if (userExists == null) {
            bindingResult
                    .rejectValue("user_task", "error.task",
                            "There is no user registered with the user name provided");
        }
        if (task.getStart() == null) {
            bindingResult
                    .rejectValue("start", "error.task",
                            "Start date cannot be blank");
        }
        if (task.getEnd() == null) {
            bindingResult
                    .rejectValue("end", "error.task",
                            "End date cannot be blank");
        }
        if (task.getEnd().compareTo(task.getStart()) < 0) {
            bindingResult
                    .rejectValue("end", "error.task",
                            "End date cannot occur before start date");
        }
        Optional<Task> taskExists = taskService.getTaskById(task.getId());
        if (taskExists == null) {
            bindingResult
                    .rejectValue("id", "error.task",
                            "There is no task with the ID provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("update-task");
        } else {
            taskService.addTask(task);
            modelAndView.addObject("successMessage",
            		"Task at ID number " + task.getId() + " has been updated successfully");
            modelAndView.addObject("task", new Task());
            modelAndView.setViewName("update-task");

        }
        return modelAndView;
    }
	
}
