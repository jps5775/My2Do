package com.my2do.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	private String data;

	@ManyToOne
	private Project fk_projects;

	public Task() {
		
	}
	
	public Project getFk_projects() {
		return fk_projects;
	}
	
	@JsonIgnore
	public void setFk_projects(Project fk_projects) {
		this.fk_projects = fk_projects;
	}
	
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", data=" + data + "]";
	}

}
