package com.my2do.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my2do.main.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
}
