package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.model.Admin;
import com.example.demo.model.Client;

@Service
public class AdminService {
	@Autowired
	private AdminDao admindao;
	
	public List<Admin> allAdmin() {
		List<Admin> rv = new ArrayList<Admin>();
		admindao.findAll().forEach((admin)-> rv.add(admin));
		return rv;
	}
	public ResponseEntity<Object> authorizeClient(Admin admin){
		String username = admin.getUsername();
		String password = admin.getPassword();
		List<Admin> rv = new ArrayList<Admin>();
		admindao .findAll().forEach((a) -> rv.add(a));
		for (int i=0;i<rv.size();i++) {
			Admin olda = rv.get(i);
			if (olda.getUsername().equals(username)) {
				if (olda.getPassword().equals(password)) {
					return new ResponseEntity<>(olda.getId(), HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<>("not logged in", HttpStatus.UNAUTHORIZED);
	}
}

