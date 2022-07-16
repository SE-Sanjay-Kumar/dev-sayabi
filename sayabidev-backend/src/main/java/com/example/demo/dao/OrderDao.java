package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Order;

public interface OrderDao extends CrudRepository<Order, Integer> {

}
