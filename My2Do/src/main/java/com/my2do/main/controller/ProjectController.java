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

import com.my2do.main.model.Project;
import com.my2do.main.service.ProjectService;

@RestController
@RequestMapping("/users/{userId}/projects")
public class ProjectController {

	@Autowired
	public ProjectService projectService;
	
	@GetMapping()
	public List<Project> getAllProjectsForUser(@PathVariable Long userId){
		return projectService.getProjectsByUser(userId);
	}
	
	@GetMapping("{projectId}")
	public Project getProject(@PathVariable Long userId, @PathVariable Long projectId){
		return projectService.getProjectByUser(userId, projectId);
	}
	
	@PostMapping()
	public Project createProject(@PathVariable Long userId, @RequestBody Project project) {
		projectService.createProjectByUser(userId, project);
		return project;
	}
	
	@PutMapping()
	public Project updateProject(@PathVariable Long userId, @RequestBody Project project) {
		projectService.updateProjectByUser(userId, project);
		return project;
	}
	
	@DeleteMapping("{projectId}")
	public void deleteProject(@PathVariable Long projectId) {
		projectService.deleteProjectByUser(projectId);
	}
	
	
}
