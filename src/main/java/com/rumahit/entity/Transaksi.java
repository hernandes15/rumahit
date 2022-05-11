package com.rumahit.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
@Table(name = "TRANSAKSI")
public class Transaksi {
	@Id
    @Column(name="id", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="tanggal_input", nullable = false)
    private Date tglInput;
	
    @Column(name="id_company", nullable = false)
    private Long idCompany;
    
    @Column(name="id_barang", nullable = false)
    private Long idBarang;
    
    @Column(name="total_barang", nullable = false)
    private Long totalBarang;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_barang", referencedColumnName = "id", 
    insertable = false, updatable = false)
    private Barang barang;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_company", referencedColumnName = "id", 
    insertable = false, updatable = false)
    private Company company;
	
}
