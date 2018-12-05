package com.my2do.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my2do.main.model.Project;
import com.my2do.main.model.User;
import com.my2do.main.repo.ProjectRepo;
import com.my2do.main.repo.UserRepo;


@Service
public class ProjectService{

	@Autowired
	public UserRepo userRepo;
	@Autowired
	public ProjectRepo projectRepo;
	
	public List<Project> getProjectsByUser(Long userId) {
		User user = null;
		try {
			user = userRepo.getOne(userId);	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return user.getProjects();
	}
	
	
	public Project getProjectByUser(Long userId, Long projectId){
		
		Project project = null;
		User user = null;
		try {
			user = userRepo.getOne(userId);
			for(Project p : user.getProjects()) {
				if(p.getProjectId().equals(projectId)) {
					project = p;
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return project; 
	}
	
	public void createProjectByUser(Long userId, Project project) {
		Project newProject = null;
		try {
			newProject = project;
			newProject.setFk_user(userRepo.getOne(userId));
			projectRepo.save(newProject);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProjectByUser(Long userId, Project project) {
		Project newProject = null;
		try {
			newProject = project;
			newProject.setFk_user(userRepo.getOne(userId));
			projectRepo.save(newProject);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteProjectByUser(Long projectId) {
		try {
			projectRepo.deleteById(projectId);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
