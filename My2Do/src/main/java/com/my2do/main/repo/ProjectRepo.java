package com.my2do.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my2do.main.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {
	
}
