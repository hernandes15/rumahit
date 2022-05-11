package com.rumahit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumahit.entity.Company;

public interface RepoCompany extends JpaRepository<Company, Long>{

}
