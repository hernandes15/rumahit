package com.rumahit.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumahit.entity.Company;
import com.rumahit.entity.Login;
import com.rumahit.entity.Transaksi;
import com.rumahit.service.impl.ServiceImpl;

@RestController
public class ControllerTestBE {
	
	@Autowired
	ServiceImpl service;
	
	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(@RequestBody Login login) {
		try {
			Object obj = service.find(login);
			
			if(Objects.isNull(obj)) {
				return null;
			}
			
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(obj), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(path = "/find-barang", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findBarang() {
		try {
			Object obj = service.findAllBarang();
			
			if(Objects.isNull(obj)) {
				return null;
			}
			
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(obj), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(path = "/find-company", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findCompany() {
		try {
			Object obj = service.findAllCompany();
			
			if(Objects.isNull(obj)) {
				return null;
			}
			
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(obj), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(path = "/csv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> csv() {
		try {
			service.csv();
			return new ResponseEntity<>("{\"status\":\"OK\"}", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(path = "/save-company", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveCom(@RequestBody Company com) {
		try {
			Object obj = service.save(com);
			
			if(Objects.isNull(obj)) {
				return null;
			}
			
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(obj), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(path = "/save-transaksi", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveTrans(@RequestBody Transaksi trans) {
		try {
			Object obj = service.save(trans);
			
			if(Objects.isNull(obj)) {
				return null;
			}
			
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(obj), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
