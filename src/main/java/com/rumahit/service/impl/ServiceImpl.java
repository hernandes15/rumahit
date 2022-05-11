package com.rumahit.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.opencsv.CSVWriter;
import com.rumahit.entity.Barang;
import com.rumahit.entity.Company;
import com.rumahit.entity.Login;
import com.rumahit.entity.Transaksi;
import com.rumahit.repository.RepoTrans;
import com.rumahit.repository.RepoBarang;
import com.rumahit.repository.RepoCompany;
import com.rumahit.repository.RepoLogin;

@Service
@Transactional
@Component
public class ServiceImpl implements com.rumahit.service.Service {

	@Autowired
	RepoLogin repoLog;
	@Autowired
	RepoTrans repoTrans;
	@Autowired
	RepoCompany repoCom;
	@Autowired
	RepoBarang repoBarang;
	
	@Value("${path.location}")
	private String location;

	@Override
	public Login find(Login login) {
		try {
			return repoLog.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Barang> findAllBarang() {
		try {
			return repoBarang.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Company> findAllCompany() {
		try {
			return repoCom.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Transaksi save(Transaksi trans) {
		try {
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			trans.setTglInput(date);
			return repoTrans.save(trans);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public Company save(Company company) {
		try {
			return repoCom.save(company);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void csv() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");  
		String path = location + "exportcsv.csv";
		File file = new File(path);
		try {
			
			List<Transaksi> trans = repoTrans.findAll();
			
			FileWriter outputfile = new FileWriter(file);

			CSVWriter writer = new CSVWriter(outputfile, '|', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

			// create a List which contains String array
			List<String[]> data = new ArrayList<String[]>();
			data.add(new String[] { "Tanggal Input", "Nama Perusahaan", "Nama Barang", "Total Barang", "Harga Barang",
					"Grand Total", "Sisa" });
			
			for (Transaksi obj : trans) {
				Long granTotal = obj.getBarang().getHarga() * obj.getTotalBarang();
				Long sisa = obj.getBarang().getStock() - obj.getTotalBarang();
				
				data.add(new String[] { dateFormat.format(obj.getTglInput()), 
						obj.getCompany().getNama(), obj.getBarang().getNama(),
						String.valueOf(obj.getTotalBarang()) , String.valueOf(obj.getBarang().getHarga()),
						String.valueOf(granTotal), String.valueOf(sisa)});
			
			}
			
			writer.writeAll(data);

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
