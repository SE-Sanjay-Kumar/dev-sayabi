package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.Client;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClientService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminservice;
	
	@CrossOrigin
	@GetMapping("/admin")
	public List<Admin> getClients() {
		return adminservice.allAdmin();
	}
	@CrossOrigin
	@PostMapping("/admin/auth")
	public ResponseEntity<Object> verifyClient(@RequestBody Admin admin) {
		return adminservice.authorizeClient(admin);
	}
}