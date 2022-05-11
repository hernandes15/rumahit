package com.rumahit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumahit.entity.Barang;
import com.rumahit.entity.Transaksi;

public interface RepoTrans extends JpaRepository<Transaksi, Long>{

}
