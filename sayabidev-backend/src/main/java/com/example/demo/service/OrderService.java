package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.model.Order;

@Service
public class OrderService {
	@Autowired
	OrderDao odao;
	
	public ResponseEntity<String> addOrder (Order o){
		if (odao.save(o)!=null) {
			return new ResponseEntity<>("order is added", HttpStatus.OK);
		}

		return new ResponseEntity<>("order is added", HttpStatus.NOT_ACCEPTABLE);
	}
	public Optional<Order> getOrder(Integer id){
		return odao.findById(id);
	}
	public List<Order> getOrders() {
		List<Order> ol = new ArrayList<>();
		odao.findAll().forEach((order)-> ol.add(order));
		return ol;
	}
}
