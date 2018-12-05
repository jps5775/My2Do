package com.my2do.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my2do.main.model.Project;
import com.my2do.main.model.Task;
import com.my2do.main.repo.ProjectRepo;
import com.my2do.main.repo.TaskRepo;

@Service
public class TaskService {
	@Autowired
	public ProjectRepo projectRepo;
	@Autowired
	public TaskRepo taskRepo;
	
	public List<Task> getTasksByProject(Long projectId) {
		Project project = null;
		try {
			project = projectRepo.getOne(projectId);	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return project.getTasks();
	}
	
	
	public Task getTaskByProject(Long projectId, Long taskId){
		return taskRepo.getOne(taskId); 
	}
	
	public void createTaskByProject(Long projectId, Task task) {
		Task newTask = null;
		try {
			newTask = task;
			newTask.setFk_projects(projectRepo.getOne(projectId));
			taskRepo.save(newTask);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateTaskByProject(Long projectId, Task task) {
		Task newTask = null;
		try {
			newTask = task;
			newTask.setFk_projects(projectRepo.getOne(projectId));
			taskRepo.save(newTask);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteTaskByProject(Long taskId) {
		try {
			taskRepo.deleteById(taskId);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
