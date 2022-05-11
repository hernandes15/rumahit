package com.rumahit.service;

import java.util.List;

import com.rumahit.entity.Barang;
import com.rumahit.entity.Company;
import com.rumahit.entity.Login;
import com.rumahit.entity.Transaksi;

public interface Service {
	public Login find (Login login);
	public List<Barang> findAllBarang ();
	public List<Company> findAllCompany ();
	public Transaksi save (Transaksi trans);
	public Company save (Company company);
}
