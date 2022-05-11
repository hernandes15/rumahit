package com.rumahit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rumahit.entity.Login;

public interface RepoLogin extends JpaRepository<Login, Long>{
	public Login findByUsernameAndPassword(String username, String password);
}
