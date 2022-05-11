package com.rumahit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumahit.entity.Barang;

public interface RepoBarang extends JpaRepository<Barang, Long>{

}
