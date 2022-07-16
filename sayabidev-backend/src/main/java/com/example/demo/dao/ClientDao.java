package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Client;

public interface ClientDao extends CrudRepository<Client, Integer> {

}
