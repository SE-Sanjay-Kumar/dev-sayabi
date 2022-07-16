package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ClientDao;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

@RestController
public class ClientController {
	@Autowired
	ClientService cservice;
	@CrossOrigin
	@PostMapping("/clients")
	public ResponseEntity<String> addClient(@RequestBody Client c) {
		return cservice.saveClient(c);
	}
	@CrossOrigin
	@GetMapping("/clients")
	public List<Client> getClients() {
		return cservice.allClients();
	}
	@CrossOrigin
	@PostMapping("/clients/auth")
	public ResponseEntity<Object> verifyClient(@RequestBody Client c) {
		return cservice.authorizeClient(c);
	}
}
