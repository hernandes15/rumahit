package com.rumahit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LOGIN")
public class Login {
	
	@Id
    @Column(name="id", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="username", nullable = false, columnDefinition = "varchar(50) default 'Admin'")
	private String username;
	@Column(name="password", nullable = false, columnDefinition = "varchar(50) default 'Admin'")
	private String password;
}
