package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.OrderDao;
import com.example.demo.model.Client;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService oservice;
	
	@CrossOrigin
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return oservice.getOrders();
	}
	@CrossOrigin
	@PostMapping("/clients/{clientid}/orders")
	public ResponseEntity<String> addOrder(@RequestBody Order order, @PathVariable String clientid) {
		order.setClient(new Client(Integer.parseInt(clientid), "",""));
		return oservice.addOrder(order);
	}
	@CrossOrigin
	@GetMapping("/orders/{order_id}")
	public Optional<Order> getOrder (@PathVariable String order_id){
		return oservice.getOrder(Integer.parseInt(order_id));
	}
}
