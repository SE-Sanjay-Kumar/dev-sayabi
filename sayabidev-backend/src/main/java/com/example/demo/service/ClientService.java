package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientDao;
import com.example.demo.model.Client;
@Service
public class ClientService {
	@Autowired
	private ClientDao cdao;
	public ResponseEntity<String> saveClient(Client c) {
		Client res = cdao.save(c);
		if (res!=null) {
			return new ResponseEntity<>("Client Is Registered Succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Client Is not Registered ", HttpStatus.NOT_ACCEPTABLE);
	}
	public List<Client> allClients() {
		List<Client> rv = new ArrayList<Client>();
		cdao.findAll().forEach((cl)-> rv.add(cl));
		return rv;
	}
	public ResponseEntity<Object> authorizeClient(Client c){
		String username = c.getUsername();
		String password = c.getPassword();
		List<Client> rv = new ArrayList<Client>();
		cdao.findAll().forEach((cl) -> rv.add(cl));
		for (int i=0;i<rv.size();i++) {
			Client oldc = rv.get(i);
			if (oldc.getUsername().equals(username)) {
				if (oldc.getPassword().equals(password)) {
					return new ResponseEntity<>(oldc.getId(), HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<>("not logged in", HttpStatus.UNAUTHORIZED);
	}
}
