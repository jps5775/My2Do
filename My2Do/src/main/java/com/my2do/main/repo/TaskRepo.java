package com.my2do.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my2do.main.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{

}
