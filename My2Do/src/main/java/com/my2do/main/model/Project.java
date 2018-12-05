package com.my2do.main.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;

	@OneToMany(mappedBy="fk_projects")
	private List<Task> tasks;

	@ManyToOne
	private User fk_user;

	private String name;
	
	public Project() {
		
	}
	
	public User getFk_user() {
		return fk_user;
	}

	@JsonIgnore
	public void setFk_user(User fk_user) {
		this.fk_user = fk_user;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", tasks=" + tasks + "]";
	}

}
