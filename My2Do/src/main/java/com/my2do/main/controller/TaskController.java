package com.my2do.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my2do.main.model.Task;
import com.my2do.main.service.TaskService;

@RestController
@RequestMapping("/users/{userId}/projects/{projectId}")
public class TaskController {
	
	@Autowired
	public TaskService taskService;
	
	@GetMapping()
	public List<Task> getAllTasksForProject(@PathVariable Long projectId){
		return taskService.getTasksByProject(projectId);
	}
	
	@GetMapping("{taskId}")
	public Task getProject(@PathVariable Long projectId, @PathVariable Long taskId){
		return taskService.getTaskByProject(projectId, taskId);
	}
	
	@PostMapping()
	public Task createProject(@PathVariable Long projectId, @RequestBody Task task) {
		taskService.createTaskByProject(projectId, task);
		return task;
	}
	
	@PutMapping()
	public Task updateProject(@PathVariable Long projectId, @RequestBody Task task) {
		taskService.updateTaskByProject(projectId, task);
		return task;
	}
	
	@DeleteMapping("{taskId}")
	public void deleteProject(@PathVariable Long taskId) {
		taskService.deleteTaskByProject(taskId);
	}

}
