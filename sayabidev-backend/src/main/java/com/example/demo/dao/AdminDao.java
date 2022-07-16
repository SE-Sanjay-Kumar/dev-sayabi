package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer> {

}
